package com.example.cairotour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import static android.view.View.GONE;
import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class TourAdapter extends ArrayAdapter<Tour> {

    private int colorResourceId;



    public TourAdapter(@NonNull Context context, ArrayList<Tour> tours, int colorResourceId) {
        super(context, 0, tours);
        this.colorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            //inflates list_item.xml
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Displaying data in the views
        Tour currentTour =getItem(position);
        TextView titleTextView = listItemView.findViewById(R.id.title);
        titleTextView.setText(currentTour.getTitleId());
        TextView subtitleTextView = listItemView.findViewById(R.id.subtitle);
        if(currentTour.hasSubtitle()){
            subtitleTextView.setText(currentTour.getSubtitleId());
            subtitleTextView.setVisibility(View.VISIBLE);
        } else {
            subtitleTextView.setVisibility(GONE);
            titleTextView.setGravity(TEXT_ALIGNMENT_CENTER);
        }
        ImageView imageView = listItemView.findViewById(R.id.image);
        if (currentTour.hasImage()) {
            imageView.setImageResource(currentTour.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(GONE);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
