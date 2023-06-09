package com.camerba.petowjava;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.camerba.petowjava.util.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {
    //
    private static final String TAG = "ShareActivity";
    //context
    private Context mContext = ShareActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.d(TAG, "onCreate: Starring Activity");

        //give instance of setupBottomNavigation view method
        setupBottomNavigation();
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
    }
}