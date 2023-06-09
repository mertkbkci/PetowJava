package com.camerba.petowjava.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.camerba.petowjava.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SignOutFragment extends Fragment {
    private static final String TAG = "SignOutFragment";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_out,container,false);
        return view;
    }
}
