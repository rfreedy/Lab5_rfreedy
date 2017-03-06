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

class ScheduleAdapter extends ArrayAdapter<Team> {
    ScheduleAdapter (Context context, ArrayList<Team> schedule) {
        super(context, R.layout.schedule_item, schedule);
    }
    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = LayoutInflater.from(getContext());
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_item, parent, false);

        Team matchItem = getItem(position);
        TextView teamName = (TextView) scheduleView.findViewById(R.id.team_name);
        TextView dateName = (TextView) scheduleView.findViewById(R.id.game_date);
        teamName.setText(matchItem.getOpponentName());
        dateName.setText(matchItem.getGameDate());
        ImageView teamLogo = (ImageView) scheduleView.findViewById(R.id.team_logo);
        String mDrawableName = matchItem.getOpponentLogo();
        int resID = getContext().getResources().getIdentifier(mDrawableName , "drawable", getContext().getPackageName());
        teamLogo.setImageResource(resID );
        return scheduleView;
    }
}
