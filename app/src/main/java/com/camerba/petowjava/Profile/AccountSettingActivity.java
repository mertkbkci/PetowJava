package com.camerba.petowjava.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.camerba.petowjava.R;

import java.util.ArrayList;


public class AccountSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        setupSettingsList();
        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(v -> finish());
    }

    private void setupSettingsList(){
        ListView listView = (ListView) findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sing_out));

        ArrayAdapter adapter = new ArrayAdapter(AccountSettingActivity.this, android.R.layout.simple_list_item_activated_1,options);
        listView.setAdapter(adapter);
    }
}