package com.camerba.petowjava.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.camerba.petowjava.util.BottomNavigationViewHelper;
import com.camerba.petowjava.R;
import com.camerba.petowjava.util.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class EditProfileFragment extends Fragment {
    private static final String TAG = "EditProfileFragment";
    private ImageView mProfilePhoto;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_profile,container,false);

        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_photo);


        setProfileImage();
        return view;
    }


    private void setProfileImage() {
        String imgURL ="encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkIw79YSfMGMJ_8Z4nkIgqc4pZrcSpuzNCUg&usqp=CAU";
        UniversalImageLoader.setImage(imgURL,mProfilePhoto,null,"https://");
    }



}
