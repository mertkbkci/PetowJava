package com.camerba.petowjava.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.camerba.petowjava.R;
import com.camerba.petowjava.util.BottomNavigationViewHelper;
import com.google.android.material.tabs.TabLayout;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    //
    private static final String TAG = "MainActivity";
    //context
    private final Context mContext = HomeActivity.this;
    //context calling
    private static final int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.d(TAG, "onCreate: Starring Activity");

        //give instance of setupBottomNavigation view method
        setupBottomNavigation();
        //tab adding methot
        setupViewPager();
    }

    /*
    Responsible to adding 3 tanbs camera, home, messages
     */

    private void setupViewPager(){
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFraagment(new CameraFragment());//index value = 0
        adapter.addFraagment(new HomeFragment());//index value = 1
        adapter.addFraagment(new MessagesFragment());//index value = 2

        ViewPager viewPager = (ViewPager) findViewById(R.id.container_viewpager);
        viewPager.setAdapter(adapter);

        //the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //icons of tabs
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_camera);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.logo);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.ic_messages);




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