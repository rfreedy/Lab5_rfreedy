package com.cse40333.rfreedy.lab2_rfreedy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        final ArrayList Colleges = new ArrayList();
        Colleges.add(new String[]{"Florida State", "Final", "Feb 11", "florida_state", "72-84", "Purcell Pavilion", "21-6"});
        Colleges.add(new String[]{"Boston College", "Final", "Feb 14", "boston_college", "76-84", "Boston College Stadium", "9-18"});
        Colleges.add(new String []{"North Carolina State", "Final", "Feb 18", "north_carolina_state","72-81", "NC State Stadium", "14-14"});
        Colleges.add(new String[]{"Georgia Tech", "2/26", "Feb 26", "georgia_tech","0-0","Purcell Pavilion", "16-11"});
        Colleges.add(new String[]{"Boston College", "3/1", "March 1", "boston_college","0-0", "Purcell Pavilion", "9-18"});
        Colleges.add(new String[]{"Louisville", "3/4", "March 4", "louisville_pic","0-0","Louisville Stadium", "22-5"});
        Colleges.add(new String[]{"ACC Tournament", "3/7", "March 7", "acc","0-0","TBD", "N/A"});
        Colleges.add(new String[]{"NCAA Tournament", "3/16", "March 16", "ncaa","0-0", "TBD", "N/A"});

        ScheduleAdapter collegeSchedule = new ScheduleAdapter(this, Colleges);

        //ListAdapter scheduleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Colleges);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(collegeSchedule);

        //Defining the click listener
        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Write code here to open the activity that will show details of the game event,i.e. if //you click on Florida State, you should see details of the match between Florida State //and Notre Dame. You need to do the following three steps.
                //create the intent to start DetailActivity
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("team", Colleges.get(position));
                startActivity(intent);

            }
        };
        scheduleListView.setOnItemClickListener (clickListener);

    }



}
