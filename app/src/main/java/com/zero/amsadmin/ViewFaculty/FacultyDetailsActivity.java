package com.zero.amsadmin.ViewFaculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zero.amsadmin.R;

public class FacultyDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private String userID;

    private Button btnManangeTimetable, btnRemoveFaculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);

        userID = getIntent().getStringExtra("USER_ID");
        Toast.makeText(this, userID, Toast.LENGTH_SHORT).show();

        btnManangeTimetable = findViewById(R.id.btn_manage_timetable);
        btnManangeTimetable.setOnClickListener(this);

        btnRemoveFaculty = findViewById(R.id.btn_remove_faculty);
        btnRemoveFaculty.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_manage_timetable:
                startActivity(new Intent(this, ManageTimetable.class).putExtra("USER_ID", userID));
                break;
            case R.id.btn_remove_faculty:
                startActivity(new Intent(this, ManageTimetable.class).putExtra("USER_ID", userID));
                break;
        }
    }
}
