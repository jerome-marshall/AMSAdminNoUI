package com.zero.amsadmin.ViewFaculty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.zero.amsadmin.Faculty;
import com.zero.amsadmin.R;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class ViewFaculty extends AppCompatActivity {
    private RecyclerView rvFacultyList;
    private FirebaseFirestore firestore;

    private List<Faculty> facultyList;
    private FacultyListAdapter facultyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_faculty);

        facultyList = new ArrayList<>();
        facultyListAdapter = new FacultyListAdapter(this, facultyList);

        rvFacultyList = findViewById(R.id.faculty_list);
        rvFacultyList.setHasFixedSize(true);
        rvFacultyList.setLayoutManager(new LinearLayoutManager(this));
        rvFacultyList.setAdapter(facultyListAdapter);

        firestore = FirebaseFirestore.getInstance();

        firestore.collection("faculty").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e != null){
                    Toast.makeText(ViewFaculty.this, "Error!", Toast.LENGTH_SHORT).show();
                }

                for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                    if(doc.getType() == DocumentChange.Type.ADDED){
                        String userID = doc.getDocument().getId();
                        
                        Faculty faculty = doc.getDocument().toObject(Faculty.class).withId(userID);
                        facultyList.add(faculty);

                        facultyListAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
