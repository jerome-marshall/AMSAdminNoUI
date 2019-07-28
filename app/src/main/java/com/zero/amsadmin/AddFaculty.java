package com.zero.amsadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddFaculty extends AppCompatActivity {
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;

    private ProgressDialog progressDialog;

    DocumentReference reference;
    private FirebaseFirestore firestore;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);

        etEmail = findViewById(R.id.et_Email);
        etName =findViewById(R.id.et_Name);
        etPassword = findViewById(R.id.et_Pass);


        progressDialog = new ProgressDialog(this);

        firestore = FirebaseFirestore.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void addUser(View view){
        progressDialog.setMessage("Adding Please Wait...");
        progressDialog.show();


        final String name = String.valueOf(etName.getText());
        final String email = String.valueOf(etEmail.getText());
        String password = String.valueOf(etPassword.getText());

        final Map<String,Object> faculty = new HashMap<>();
        faculty.put("name", name);
        faculty.put("email", email);

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            Toast.makeText(AddFaculty.this, "Success!", Toast.LENGTH_SHORT).show();
                        }else{
                            //display some message here
                            Toast.makeText(AddFaculty.this,"Error",Toast.LENGTH_LONG).show();
                        }

                        if(firebaseAuth.getCurrentUser() != null) {
                            String uid = firebaseAuth.getCurrentUser().getUid();

                            reference = firestore.collection("faculty").document(uid);

                            reference.set(faculty);
                            Toast.makeText(AddFaculty.this, uid, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(AddFaculty.this, "Data not added", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });



    }
}
