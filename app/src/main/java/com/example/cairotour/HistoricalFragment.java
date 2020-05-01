package com.example.cairotour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricalFragment extends Fragment {

    public HistoricalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list,container,false);

        //Creating an ArrayList that will be displayed
        final ArrayList<Tour> tours = new ArrayList<>();
        tours.add(new Tour(R.string.historical_title_one,R.string.cafe_subtitle_one,
                R.drawable.historical_number_one,R.string.location_historical_one));
        tours.add(new Tour(R.string.historical_title_two,R.string.cafe_subtitle_two,
                R.drawable.historical_number_two,R.string.location_historical_two));
        tours.add(new Tour(R.string.historical_title_three,R.string.cafe_subtitle_three,
                R.drawable.historical_number_three,R.string.location_historical_three));
        tours.add(new Tour(R.string.historical_title_four,R.string.cafe_subtitle_four,
                R.drawable.historical_number_four,R.string.location_historical_four));
        tours.add(new Tour(R.string.historical_title_five,R.string.cafe_subtitle_five,
                R.drawable.historical_number_five,R.string.location_historical_five));
        tours.add(new Tour(R.string.historical_title_six,R.string.cafe_subtitle_six,
                R.drawable.historical_number_six,R.string.location_historical_six));
        tours.add(new Tour(R.string.historical_title_seven,R.string.cafe_subtitle_seven,
                R.drawable.historical_number_seven,R.string.location_historical_seven));
        tours.add(new Tour(R.string.historical_title_eight,R.string.cafe_subtitle_eight,
                R.drawable.historical_number_eight,R.string.location_historical_eight));
        tours.add(new Tour(R.string.historical_title_nine,R.string.cafe_subtitle_nine,
                R.drawable.historical_number_nine,R.string.location_historical_nine));
        tours.add(new Tour(R.string.historical_title_ten,R.string.cafe_subtitle_ten,
                R.drawable.historical_number_ten,R.string.location_historical_ten));

        //Setting the custom adapter for the ListView
        TourAdapter adapter = new TourAdapter(getActivity(),tours, R.color.historical);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //ItemCLickListener of the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //When you click on any item, it opens the location of that place on Google Maps
                Tour tour = tours.get(position);
                Uri locationUri = Uri.parse(getString(tour.getUrlResourceId()));
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, locationUri);
                startActivity(websiteIntent);
            }
        });
        return rootView;
    }
}
