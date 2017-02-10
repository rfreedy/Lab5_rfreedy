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
        Colleges.add("Florida State");
        Colleges.add("Boston College");
        Colleges.add("North Carolina State");
        Colleges.add("Georgia Tech");
        Colleges.add("Boston College");
        Colleges.add("Louisville");
        Colleges.add("ACC Tournament");
        Colleges.add("NCAA Tournament");
        ArrayList Dates = new ArrayList();
        Dates.add("Feb 11");
        Dates.add("Feb 14");
        Dates.add("Feb 18");
        Dates.add("Feb 26");
        Dates.add("March 1");
        Dates.add("March 4");
        Dates.add("March 7");
        Dates.add("March 16");
        ArrayList pictures = new ArrayList();
        Colleges.add("florida_state.jpg");
        Colleges.add("boston_college.png");
        Colleges.add("north_carolina_state.png");
        Colleges.add("georgia_tech.png");
        Colleges.add("boston_college.png");
        Colleges.add("louisville_pic.png");
        Colleges.add("acc.jpg");
        Colleges.add("ncaa.png");

        ScheduleAdapter collegeSchedule = new ScheduleAdapter(this, Colleges);

        //ListAdapter scheduleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Colleges);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(collegeSchedule);
    }
}
