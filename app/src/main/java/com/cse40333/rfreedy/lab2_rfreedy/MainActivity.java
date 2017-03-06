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

import static android.view.ViewGroup.FOCUS_BLOCK_DESCENDANTS;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final String arr[] = {"Florida State", "Boston College", "North Carolina State", "Georgia Tech", "Boston College", "Louisville","ACC Tournament", "NCAA Tournament"};

        final ArrayList <String[]> Colleges = new ArrayList<String[]>();
        /*Colleges.add(new String[]{"Florida State", "Final", "Feb 11", "florida_state", "72-84", "Purcell Pavilion", "21-6"});
        Colleges.add(new String[]{"Boston College", "Final", "Feb 14", "boston_college", "76-84", "Boston College Stadium", "9-18"});
        Colleges.add(new String []{"North Carolina State", "Final", "Feb 18", "north_carolina_state","72-81", "NC State Stadium", "14-14"});
        Colleges.add(new String[]{"Georgia Tech", "2/26", "Feb 26", "georgia_tech","0-0","Purcell Pavilion", "16-11"});
        Colleges.add(new String[]{"Boston College", "3/1", "March 1", "boston_college","0-0", "Purcell Pavilion", "9-18"});
        Colleges.add(new String[]{"Louisville", "3/4", "March 4", "louisville_pic","0-0","Louisville Stadium", "22-5"});
        Colleges.add(new String[]{"ACC Tournament", "3/7", "March 7", "acc","0-0","TBD", "N/A"});
        Colleges.add(new String[]{"NCAA Tournament", "3/16", "March 16", "ncaa","0-0", "TBD", "N/A"});*/

        final ArrayList <String []> al = new ArrayList <String []>();
        al.add(new String[]{"florida_state", "Florida State", "Feb 11"});
        al.add(new String[]{"boston_college", "Boston College", "Feb 14"});
        al.add(new String[]{"north_carolina_state", "North Carolina State", "Feb 18"});
        al.add(new String[]{"georgia_tech", "Georgia Tech", "Feb 26"});
        al.add(new String[]{"boston_college", "Boston College", "March 1"});
        al.add(new String[]{"louisville_pic", "Louisville", "March 4"});
        al.add(new String[]{"acc", "ACC Tournament", "March 7"});
        al.add(new String[]{"ncaa", "NCAA Tournament", "March 16"});

        final ArrayList<Team> teams = new ArrayList<>();
        Team florida_state = new Team("Florida State", "Final", "Feb 11", "florida_state", "72-84", "Purcell Pavilion", "21-6");
        Team boston_college_1 = new Team("Boston College", "Final", "Feb 14", "boston_college", "76-84", "Boston College Stadium", "9-18");
        Team nc_state = new Team("North Carolina State", "Final", "Feb 18", "north_carolina_state","72-81", "NC State Stadium", "14-14");
        Team georgia_tech = new Team("Georgia Tech", "2/26", "Feb 26", "georgia_tech","0-0","Purcell Pavilion", "16-11");
        Team boston_college_2 = new Team("Boston College", "3/1", "March 1", "boston_college","0-0", "Purcell Pavilion", "9-18");
        Team louisville = new Team("Louisville", "3/4", "March 4", "louisville_pic","0-0","Louisville Stadium", "22-5");
        Team acc_tournament = new Team("ACC Tournament", "3/7", "March 7", "acc","0-0","TBD", "N/A");
        Team ncaa_tournament = new Team("NCAA Tournament", "3/16", "March 16", "ncaa","0-0", "TBD", "N/A");

        teams.add(florida_state);
        teams.add(boston_college_1);
        teams.add(nc_state);
        teams.add(georgia_tech);
        teams.add(boston_college_2);
        teams.add(louisville);
        teams.add(acc_tournament);
        teams.add(ncaa_tournament);

        MyCsvFileReader file_reader = new MyCsvFileReader(getApplicationContext());
        //Colleges = file_reader.readCsvFile();

        ScheduleAdapter collegeSchedule = new ScheduleAdapter(this, teams);

        //ListAdapter scheduleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Colleges);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(collegeSchedule);

        //Defining the click listener

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Write code here to open the activity that will show details of the game event,i.e. if //you click on Florida State, you should see details of the match between Florida State //and Notre Dame. You need to do the following three steps.
                //create the intent to start DetailActivity


                Intent newIntent = new Intent(MainActivity.this, DetailActivity.class);
                newIntent.putExtra("Team", teams.get(position));
                startActivity(newIntent);
            }
        };

        scheduleListView.setOnItemClickListener(clickListener);
        scheduleListView.setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);

    }



}
