package com.camerba.petowjava.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class GridImageAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private LayoutInflater mInflater;
    private int layoutResource;
    private String mAppend;
    private ArrayList<String> imgURLs;

    public GridImageAdapter(@NonNull Context context, int resource, Context mContext, LayoutInflater mInflater, int layoutResource, String mAppend, ArrayList<String> imgURLs) {
        super(context, resource);
        this.mContext = mContext;
        this.mInflater = mInflater;
        this.layoutResource = layoutResource;
        this.mAppend = mAppend;
        this.imgURLs = imgURLs;
    }

    public GridImageAdapter(@NonNull Context context, int resource, int textViewResourceId, Context mContext, LayoutInflater mInflater, int layoutResource, String mAppend, ArrayList<String> imgURLs) {
        super(context, resource, textViewResourceId);
        this.mContext = mContext;
        this.mInflater = mInflater;
        this.layoutResource = layoutResource;
        this.mAppend = mAppend;
        this.imgURLs = imgURLs;
    }

    public GridImageAdapter(@NonNull Context context, int resource, @NonNull String[] objects, Context mContext, LayoutInflater mInflater, int layoutResource, String mAppend, ArrayList<String> imgURLs) {
        super(context, resource, objects);
        this.mContext = mContext;
        this.mInflater = mInflater;
        this.layoutResource = layoutResource;
        this.mAppend = mAppend;
        this.imgURLs = imgURLs;
    }

    public GridImageAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull String[] objects, Context mContext, LayoutInflater mInflater, int layoutResource, String mAppend, ArrayList<String> imgURLs) {
        super(context, resource, textViewResourceId, objects);
        this.mContext = mContext;
        this.mInflater = mInflater;
        this.layoutResource = layoutResource;
        this.mAppend = mAppend;
        this.imgURLs = imgURLs;
    }

    public GridImageAdapter(@NonNull Context context, int resource, @NonNull List<String> objects, Context mContext, LayoutInflater mInflater, int layoutResource, String mAppend, ArrayList<String> imgURLs) {
        super(context, resource, objects);
        this.mContext = mContext;
        this.mInflater = mInflater;
        this.layoutResource = layoutResource;
        this.mAppend = mAppend;
        this.imgURLs = imgURLs;
    }

    public GridImageAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<String> objects, Context mContext, LayoutInflater mInflater, int layoutResource, String mAppend, ArrayList<String> imgURLs) {
        super(context, resource, textViewResourceId, objects);
        this.mContext = mContext;
        this.mInflater = mInflater;
        this.layoutResource = layoutResource;
        this.mAppend = mAppend;
        this.imgURLs = imgURLs;
    }
}
