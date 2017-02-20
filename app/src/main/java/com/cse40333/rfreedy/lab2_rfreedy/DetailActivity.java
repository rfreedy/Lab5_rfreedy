package com.cse40333.rfreedy.lab2_rfreedy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

import static java.security.AccessController.getContext;

public class DetailActivity extends Activity {

    @Override
    public void onCreate (Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_detail);

        String[] stringInfo = getIntent().getStringArrayExtra("team");

        //initialize all the widgets of your layout file here.
        TextView gameLocation = (TextView) findViewById(R.id.game_location);
        gameLocation.setText(stringInfo[5]);
        TextView gameDate = (TextView) findViewById(R.id.game_date);
        gameDate.setText(stringInfo[2]);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        TextView outcome = (TextView) findViewById(R.id.outcome);
        outcome.setText(stringInfo[1]);
        TextView score = (TextView) findViewById(R.id.score);
        score.setText(stringInfo[4]);
        TextView notreDameName = (TextView) findViewById(R.id.notre_dame_name);
        notreDameName.setText("Notre Dame Fighting Irish");
        TextView notreDameRecord = (TextView) findViewById(R.id.notre_dame_record);
        notreDameRecord.setText("21-7");
        TextView opponentName = (TextView) findViewById(R.id.opponent_name);
        opponentName.setText(stringInfo[0]);
        TextView opponentRecord = (TextView) findViewById(R.id.opponent_record);
        opponentRecord.setText(stringInfo[6]);

        //initializing the image views
        //Notre Dame Logo
        ImageView notreDameLogo = (ImageView) findViewById(R.id.team_logo);
        String mDrawableName = "notredamelogo";
        int resID = getApplicationContext().getResources().getIdentifier(mDrawableName , "drawable", getApplicationContext().getPackageName());
        notreDameLogo.setImageResource(resID );

        //Opponent Logo
        ImageView opponentTeamLogo = (ImageView) findViewById(R.id.team_logo);
        String mDrawableName2 = stringInfo[3];
        int resID2 = getApplicationContext().getResources().getIdentifier(mDrawableName2 , "drawable", getApplicationContext().getPackageName());
        opponentTeamLogo.setImageResource(resID2);

        //initializing the camera
        Button camera =  (Button) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
            }
        });



    }
}
