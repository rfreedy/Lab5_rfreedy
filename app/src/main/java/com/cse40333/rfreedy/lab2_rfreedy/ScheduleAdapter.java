package com.cse40333.rfreedy.lab2_rfreedy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rfreedy on 2/10/2017.
 */

class ScheduleAdapter {
    ScheduleAdapter (Context context, ArrayList<String[]> schedule, ArrayList<String[]> dates, ArrayList<String[]> logos) {
        super(context, R.layout.schedule_item, schedule, dates, logos);
    }
    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = LayoutInflater.from(getContext());
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_item, parent, false);

        String matchItem = getItem(position);
        TextView teamName = (TextView) scheduleView.findViewById(R.id.team_name);
        TextView gameDate = (TextView) scheduleView.findViewById(R.id.game_date);
        ImageView teamLogo = (ImageView) scheduleView.findViewById(R.id.teamLogo);
        String mDrawableName = matchItem[0];
        int resID = getContext().getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        teamLogo.setImageResource(resID );
        teamName.setText(matchItem);
        return scheduleView;
    }
}
