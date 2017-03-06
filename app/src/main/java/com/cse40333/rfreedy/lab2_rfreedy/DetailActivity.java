package com.cse40333.rfreedy.lab2_rfreedy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;


import static java.security.AccessController.getContext;

public class DetailActivity extends Activity {
    private static final int CAMERA_REQUEST = 1888;
    @Override
    public void onCreate (Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_detail);

        //String[] stringInfo = getIntent().getStringArrayExtra("team");
        Team team = (Team) getIntent().getSerializableExtra("Team");

        //initialize all the widgets of your layout file here.
        TextView gameLocation = (TextView) findViewById(R.id.game_location);
        gameLocation.setText(team.getGameLocation());
        TextView gameDate = (TextView) findViewById(R.id.game_date);
        gameDate.setText(team.getGameDate());
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        TextView outcome = (TextView) findViewById(R.id.outcome);
        outcome.setText(team.getGameOutcome());
        TextView score = (TextView) findViewById(R.id.score);
        score.setText(team.getGameScore());
        TextView notreDameName = (TextView) findViewById(R.id.notre_dame_name);
        notreDameName.setText("Notre Dame Fighting Irish");
        TextView notreDameRecord = (TextView) findViewById(R.id.notre_dame_record);
        notreDameRecord.setText("21-7");
        TextView opponentName = (TextView) findViewById(R.id.opponent_name);
        opponentName.setText(team.getOpponentName());
        TextView opponentRecord = (TextView) findViewById(R.id.opponent_record);
        opponentRecord.setText(team.getOpponentRecord());

        //initializing the image views
        //Notre Dame Logo
        ImageView notreDameLogo = (ImageView) findViewById(R.id.team_logo);
        String mDrawableName = "notredamelogo";
        int resID = getApplicationContext().getResources().getIdentifier(mDrawableName, "drawable", getApplicationContext().getPackageName());
        notreDameLogo.setImageResource(resID);

        //Opponent Logo
        ImageView opponentTeamLogo = (ImageView) findViewById(R.id.team_logo);
        String mDrawableName2 = team.getOpponentLogo();
        int resID2 = getApplicationContext().getResources().getIdentifier(mDrawableName2, "drawable", getApplicationContext().getPackageName());
        opponentTeamLogo.setImageResource(resID2);

        //initializing the camera
        Button camera = (Button) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
            }
        });

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File PictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureName = getPictureName();
        File imageFile = new File(PictureDirectory, pictureName);
        Uri pictureUri = Uri.fromFile(imageFile);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    private String getPictureName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        return "BestMoments" + timestamp + ".jpg";
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                Intent photoGalleryIntent = new Intent(Intent.ACTION_PICK);
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

                String pictureDirectoryPath = pictureDirectory.getPath();
                Uri imageUri = Uri.parse(pictureDirectoryPath);
                InputStream inputStream;
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);

                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    ImageView imgView = (ImageView) findViewById(R.id.cameraPicture);
                    imgView.setImageBitmap(image);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
