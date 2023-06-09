package com.camerba.petowjava.util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import com.camerba.petowjava.HomeActivity;
import com.camerba.petowjava.LikesActivity;
import com.camerba.petowjava.ProfileActivity;
import com.camerba.petowjava.R;
import com.camerba.petowjava.SearchActivity;
import com.camerba.petowjava.ShareActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import androidx.annotation.NonNull;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up Bottom Navigation view");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;

                if (item.getItemId() == R.id.ic_home) {
                    intent = new Intent(context, HomeActivity.class);
                } else if (item.getItemId() == R.id.ic_search) {
                    intent = new Intent(context, SearchActivity.class);
                } else if (item.getItemId() == R.id.ic_share) {
                    intent = new Intent(context, ShareActivity.class);
                } else if (item.getItemId() == R.id.ic_alert) {
                    intent = new Intent(context, LikesActivity.class);
                } else if (item.getItemId() == R.id.ic_profile) {
                    intent = new Intent(context, ProfileActivity.class);
                }

                if (intent != null) {
                    context.startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }







}
