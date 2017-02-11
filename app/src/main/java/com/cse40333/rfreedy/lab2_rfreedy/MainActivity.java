package com.cse40333.rfreedy.lab2_rfreedy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String Colleges[] = {"Florida State", "Boston College", "North Carolina State", "Georgia Tech", "Boston College", "Louisville","ACC Tournament", "NCAA Tournament"};

        ArrayList Colleges = new ArrayList();
        Colleges.add(new String[]{"Florida State", "Feb 11", "florida_state"});
        Colleges.add(new String[]{"Boston College", "Feb 14", "boston_college"});
        Colleges.add(new String []{"North Carolina State", "Feb 18", "north_carolina_state"});
        Colleges.add(new String[]{"Georgia Tech", "Feb 26", "georgia_tech"});
        Colleges.add(new String[]{"Boston College", "March 1", "boston_college"});
        Colleges.add(new String[]{"Louisville", "March 4", "louisville_pic"});
        Colleges.add(new String[]{"ACC Tournament", "March 7", "acc"});
        Colleges.add(new String[]{"NCAA Tournament", "March 16", "ncaa"});

        ScheduleAdapter collegeSchedule = new ScheduleAdapter(this, Colleges);

        //ListAdapter scheduleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Colleges);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(collegeSchedule);
    }
}
