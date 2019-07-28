package com.zero.amsadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zero.amsadmin.ViewFaculty.ViewFaculty;

public class ManageFaculty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_staffs);
    }

    public void addFaculty(View view){
        startActivity(new Intent(getApplicationContext(), AddFaculty.class));

    }

    public void viewFaculty(View view){
        startActivity(new Intent(getApplicationContext(), ViewFaculty.class));

    }

    public void removeFaculty(View view){

    }
}
