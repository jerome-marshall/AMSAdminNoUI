package com.zero.amsadmin.ViewFaculty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.zero.amsadmin.Faculty;
import com.zero.amsadmin.R;

import java.util.ArrayList;
import java.util.List;

public class FacultyDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private String userID;

    private Button btnManangeTimetable, btnRemoveFaculty;

    private DocumentReference reference;

    private FacultyListAdapter facultyListAdapter;
    private List<Faculty> facultyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);

        facultyList = new ArrayList<>();
        facultyListAdapter = new FacultyListAdapter(this, facultyList);

        userID = getIntent().getStringExtra("USER_ID");

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        reference = firestore.collection("faculty")
                .document(userID);

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
                showAlert();
        }
    }

    public void showAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete Faculty?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        reference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(FacultyDetailsActivity.this, "Faculty Removed", Toast.LENGTH_SHORT).show();
                            }
                        });
                        facultyListAdapter.notifyDataSetChanged();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
