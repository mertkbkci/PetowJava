package com.camerba.petowjava.Profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.camerba.petowjava.R;
import com.camerba.petowjava.util.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {
    //
    private static final String TAG = "ProfileActivity";
    //context
    private final Context mContext = ProfileActivity.this;
    //context calling
    private static final int ACTIVITY_NUM = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Starring Activity");

        //give instance of setupBottomNavigation view method
        setupBottomNavigation();
    }

    /*
    *SetupToolBar method
     */

    private void  setupToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Log.w(TAG, "onMenuItemClick: click menu item" + item );

                if (item.getItemId() == R.id.profileMenu) {
                    Log.d(TAG, "onMenuItemClick: Navigating to profile preferences");
                }


                return false;
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