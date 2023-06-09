package com.camerba.petowjava.Home;



import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;



public class SectionPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG ="SectionPagerAdapter";
    private final List<Fragment> mFragmentList = new ArrayList<>();

    //constructor
    public SectionPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
//implament method pager adapter
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

  //method of addFragment
    public void addFraagment(Fragment fragment) {

        mFragmentList.add(fragment);
    }


}
