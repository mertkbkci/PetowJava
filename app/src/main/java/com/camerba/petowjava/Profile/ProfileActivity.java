package com.camerba.petowjava.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.camerba.petowjava.AccountSettingActivity;
import com.camerba.petowjava.R;
import com.camerba.petowjava.util.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    //context
    private final Context mContext = ProfileActivity.this;
    //context calling
    private static final int ACTIVITY_NUM = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Log.d(TAG, "onCreate: Starring ");


        //setupBottomNavigation();
        setupToolBar();
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