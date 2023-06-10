package com.camerba.petowjava.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.camerba.petowjava.R;
import com.camerba.petowjava.util.BottomNavigationViewHelper;
import com.camerba.petowjava.util.GridImageAdapter;
import com.camerba.petowjava.util.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    //context
    private final Context mContext = ProfileActivity.this;
    //context calling

    private ProgressBar mProgressBar;
    private ImageView profilePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Log.d(TAG, "onCreate: Starring ");


        //setupBottomNavigation();

        setupToolBar();
        setupActivityWidgets();
        setupProfileImage();

    }

    private void tempGridSetup(){
        //here the list of images ı want to show cas
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://i.imgur.com/aHu0Tzg.jpeg");
        imgURLs.add(" https://i.imgur.com/NwF7IG1.jpeg ");
        imgURLs.add("https://i.imgur.com/9IMQPSZ.jpeg");
        imgURLs.add("https://i.imgur.com/dFZwm1Q.jpeg");
        imgURLs.add("https://i.imgur.com/KcPoODW.jpeg");
        imgURLs.add("https://i.imgur.com/UAKnqhr.jpeg");


        setupImageGrid(imgURLs);
    }
    private void setupImageGrid(ArrayList<String> imgURLs){


        GridView gridView = (GridView) findViewById(R.id.gridView);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);
    }

    private void setupProfileImage(){
        String imgURL ="data:image/jpeg;base64,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";
        UniversalImageLoader.setImage(imgURL,profilePhoto,mProgressBar,"https://");

    }
    private void setupActivityWidgets(){
        mProgressBar =(ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);

    }

    /*
    *SetupToolBar method
     */

    private void  setupToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = findViewById(R.id.profileMenu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, AccountSettingActivity.class);
                startActivity(i);
            }
        });
    }
    /*
    in this bottom navigation function will
    */
    private void setupBottomNavigation(){

        Log.d(TAG, "setupBottomNavigation: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)
                findViewById(R.id.bottomNavigationViewBar);

        //bottom navigation view helper
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        //enable navigation bar this
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        //call getMenu for animation and select perper
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }


}