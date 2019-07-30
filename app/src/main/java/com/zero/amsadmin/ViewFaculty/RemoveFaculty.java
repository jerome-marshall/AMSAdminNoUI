package com.zero.amsadmin.ViewFaculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.zero.amsadmin.R;

public class RemoveFaculty extends AppCompatActivity {
    private String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_faculty);

        userID = getIntent().getStringExtra("USER_ID");
    }
}
