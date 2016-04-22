package com.example.monty.walkingapp;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomWalkAdapter extends ArrayAdapter<Walks> {
    public CustomWalkAdapter(Context context, ArrayList<Walks> walks) {
        super(context, 0, walks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Walks walk = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }
        // Lookup view for data population
        TextView wName = (TextView) convertView.findViewById(R.id.item_walk_name);
        TextView wLocation = (TextView) convertView.findViewById(R.id.item_walk_location);
        TextView wDiff = (TextView) convertView.findViewById(R.id.item_walk_difficulty);
        TextView wDist = (TextView) convertView.findViewById(R.id.item_walk_distance);
        TextView wLength = (TextView) convertView.findViewById(R.id.item_walk_length);
        // Populate the data into the template view using the data object
        wName.setText(Walks.walk_name);
        wLocation.setText(Walks.walk_location);
        wDiff.setText(Walks.walk_difficulty);
        //wDist.setText(walk.walk_distance);
        //wLength.setText(walk.walk_length);
        // Return the completed view to render on screen
        return convertView;
    }
}
