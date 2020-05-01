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
public class TipsFragment extends Fragment {



    public TipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.tour_list,container,false);

        //Creating an ArrayList that will be displayed
        final ArrayList<Tour> tours = new ArrayList<>();
        tours.add(new Tour(R.string.tip_one,R.drawable.tips_number_one));
        tours.add(new Tour(R.string.tip_two,R.drawable.tips_number_two));
        tours.add(new Tour(R.string.tip_three,R.drawable.tips_number_three));
        tours.add(new Tour(R.string.tip_four,R.drawable.tips_number_four));
        tours.add(new Tour(R.string.tip_five,R.drawable.tips_number_five));
        tours.add(new Tour(R.string.tip_six,R.drawable.tips_number_six));
        tours.add(new Tour(R.string.tip_seven,R.drawable.tips_number_seven));
        tours.add(new Tour(R.string.tip_eight,R.drawable.tips_number_eight));
        tours.add(new Tour(R.string.tip_nine,R.drawable.tips_number_nine));
        tours.add(new Tour(R.string.tip_ten,R.drawable.tips_number_ten));

        //Setting the custom adapter for the ListView
        TourAdapter adapter = new TourAdapter(getActivity(),tours,R.color.Tips);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //ItemCLickListener of the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Nothing to do
            }
        });
        return rootView;
    }

    }

