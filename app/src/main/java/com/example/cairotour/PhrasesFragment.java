package com.example.cairotour;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };



    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list,container,false);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //Creating an ArrayList that will be displayed
        final ArrayList<Tour> tours = new ArrayList<>();
        tours.add(new Tour(R.string.phrases_title_one,R.string.phrases_subtitle_one,R.raw.phrases_number_one));
        tours.add(new Tour(R.string.phrases_title_two,R.string.phrases_subtitle_two,R.raw.phrases_number_two));
        tours.add(new Tour(R.string.phrases_title_three,R.string.phrases_subtitle_three,R.raw.phrases_number_three));
        tours.add(new Tour(R.string.phrases_title_four,R.string.phrases_subtitle_four,R.raw.phrases_number_four));
        tours.add(new Tour(R.string.phrases_title_five,R.string.phrases_subtitle_five,R.raw.phrases_number_five));
        tours.add(new Tour(R.string.phrases_title_six,R.string.phrases_subtitle_six,R.raw.phrases_number_six));
        tours.add(new Tour(R.string.phrases_title_seven,R.string.phrases_subtitle_seven,R.raw.phrases_number_seven));
        tours.add(new Tour(R.string.phrases_title_eight,R.string.phrases_subtitle_eight,R.raw.phrases_number_eight));
        tours.add(new Tour(R.string.phrases_title_nine,R.string.phrases_subtitle_nine,R.raw.phrases_number_nine));
        tours.add(new Tour(R.string.phrases_title_ten,R.string.phrases_subtitle_ten,R.raw.phrases_number_ten));

        //Setting the custom adapter for the ListView
        TourAdapter adapter = new TourAdapter(getActivity(),tours,R.color.phrases);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //ItemCLickListener of the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Starts the audio with the specific phrase of the item
                releaseMediaPlayer();
                Tour tour = tours.get(position);
                int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer = MediaPlayer.create(getActivity(), tour.getAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
