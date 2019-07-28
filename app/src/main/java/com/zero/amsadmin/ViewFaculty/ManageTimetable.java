package com.zero.amsadmin.ViewFaculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.zero.amsadmin.R;

import java.util.HashMap;
import java.util.Map;

public class ManageTimetable extends AppCompatActivity implements View.OnClickListener, TimeTableEditDialog.TimeTableEditDialogListener {
    private CardView cd1, cd2, cd3, cd4, cd5, cd6, cd7;
    private TextView txtDept1, txtDept2, txtDept3, txtDept4, txtDept5, txtDept6, txtDept7;
    private TextView txtSub1, txtSub2, txtSub3, txtSub4, txtSub5, txtSub6, txtSub7;
    private int clickFlag;
    private String userID;
    private FacultyTimetable facultyTimetable;
    private FirebaseFirestore firestore;
    private DocumentReference reference;
    private DocumentSnapshot documentSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_timetable);

        userID = getIntent().getStringExtra("USER_ID");

        firestore = FirebaseFirestore.getInstance();

        cd1 = findViewById(R.id.cd_1);
        cd1.setOnClickListener(this);
        cd2 = findViewById(R.id.cd_2);
        cd2.setOnClickListener(this);
        cd3 = findViewById(R.id.cd_3);
        cd3.setOnClickListener(this);
        cd4 = findViewById(R.id.cd_4);
        cd4.setOnClickListener(this);
        cd5 = findViewById(R.id.cd_5);
        cd5.setOnClickListener(this);
        cd6 = findViewById(R.id.cd_6);
        cd6.setOnClickListener(this);
        cd7 = findViewById(R.id.cd_7);
        cd7.setOnClickListener(this);

        txtDept1 = findViewById(R.id.txt_tt_dept1);
        txtDept2 = findViewById(R.id.txt_tt_dept2);
        txtDept3 = findViewById(R.id.txt_tt_dept3);
        txtDept4 = findViewById(R.id.txt_tt_dept4);
        txtDept5 = findViewById(R.id.txt_tt_dept5);
        txtDept6 = findViewById(R.id.txt_tt_dept6);
        txtDept7 = findViewById(R.id.txt_tt_dept7);

        txtSub1 = findViewById(R.id.txt_tt_sub1);
        txtSub2 = findViewById(R.id.txt_tt_sub2);
        txtSub3 = findViewById(R.id.txt_tt_sub3);
        txtSub4 = findViewById(R.id.txt_tt_sub4);
        txtSub5 = findViewById(R.id.txt_tt_sub5);
        txtSub6 = findViewById(R.id.txt_tt_sub6);
        txtSub7 = findViewById(R.id.txt_tt_sub7);

        clickFlag = 0;

        loadData();
    }

    public void openDialog() {
        TimeTableEditDialog timeTableEditDialog = new TimeTableEditDialog();
        timeTableEditDialog.show(getSupportFragmentManager(), "Edit TT Dialog");
    }

    @Override
    public void applyTexts(String dept, String sub) {
        switch (clickFlag){
            case 1:
                txtDept1.setText(dept);
                txtSub1.setText(sub);

                final Map<String,Object> faculty1 = new HashMap<>();
                faculty1.put("dept", dept);
                faculty1.put("sub", sub);

                reference = firestore.collection("faculty")
                        .document(userID)
                        .collection("timetable")
                        .document("1");
                reference.set(faculty1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ManageTimetable.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                });

                break;

            case 2:
                txtDept2.setText(dept);
                txtSub2.setText(sub);

                final Map<String,Object> faculty2 = new HashMap<>();
                faculty2.put("dept", dept);
                faculty2.put("sub", sub);

                reference = firestore.collection("faculty")
                        .document(userID)
                        .collection("timetable")
                        .document("2");
                reference.set(faculty2).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ManageTimetable.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                });

                break;

            case 3:
                txtDept3.setText(dept);
                txtSub3.setText(sub);

                final Map<String,Object> faculty3 = new HashMap<>();
                faculty3.put("dept", dept);
                faculty3.put("sub", sub);

                reference = firestore.collection("faculty")
                        .document(userID)
                        .collection("timetable")
                        .document("3");
                reference.set(faculty3).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ManageTimetable.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                });

                break;

            case 4:
                txtDept4.setText(dept);
                txtSub4.setText(sub);

                final Map<String,Object> faculty4 = new HashMap<>();
                faculty4.put("dept", dept);
                faculty4.put("sub", sub);

                reference = firestore.collection("faculty")
                        .document(userID)
                        .collection("timetable")
                        .document("4");
                reference.set(faculty4).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ManageTimetable.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                });

                break;

            case 5:
                txtDept5.setText(dept);
                txtSub5.setText(sub);

                final Map<String,Object> faculty5 = new HashMap<>();
                faculty5.put("dept", dept);
                faculty5.put("sub", sub);

                reference = firestore.collection("faculty")
                        .document(userID)
                        .collection("timetable")
                        .document("5");
                reference.set(faculty5).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ManageTimetable.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                });

                break;

            case 6:
                txtDept6.setText(dept);
                txtSub6.setText(sub);

                final Map<String,Object> faculty6 = new HashMap<>();
                faculty6.put("dept", dept);
                faculty6.put("sub", sub);

                reference = firestore.collection("faculty")
                        .document(userID)
                        .collection("timetable")
                        .document("6");
                reference.set(faculty6).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ManageTimetable.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                });

                break;

            case 7:
                txtDept7.setText(dept);
                txtSub7.setText(sub);

                final Map<String,Object> faculty7 = new HashMap<>();
                faculty7.put("dept", dept);
                faculty7.put("sub", sub);

                reference = firestore.collection("faculty")
                        .document(userID)
                        .collection("timetable")
                        .document("7");
                reference.set(faculty7).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ManageTimetable.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
        }

    }

    public  void loadData(){

        for(int i = 1; i<=7; i++){
            String period = String.valueOf(i);
            reference = firestore.collection("faculty")
                    .document(userID)
                    .collection("timetable")
                    .document(period);
            switch (i){
                case 1:
                    reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                documentSnapshot = task.getResult();
                                txtDept1.setText(documentSnapshot.get("dept").toString());
                                txtSub1.setText(documentSnapshot.get("sub").toString());
                            }
                        }
                    });
                    break;

                case 2:
                    reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                documentSnapshot = task.getResult();
                                txtDept2.setText(documentSnapshot.get("dept").toString());
                                txtSub2.setText(documentSnapshot.get("sub").toString());
                            }
                        }
                    });
                    break;

                case 3:
                    reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                documentSnapshot = task.getResult();
                                txtDept3.setText(documentSnapshot.get("dept").toString());
                                txtSub3.setText(documentSnapshot.get("sub").toString());
                            }
                        }
                    });
                    break;

                case 4:
                    reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                documentSnapshot = task.getResult();
                                txtDept4.setText(documentSnapshot.get("dept").toString());
                                txtSub4.setText(documentSnapshot.get("sub").toString());
                            }
                        }
                    });
                    break;

                case 5:
                    reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                documentSnapshot = task.getResult();
                                txtDept5.setText(documentSnapshot.get("dept").toString());
                                txtSub5.setText(documentSnapshot.get("sub").toString());
                            }
                        }
                    });
                    break;

                case 6:
                    reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                documentSnapshot = task.getResult();
                                txtDept6.setText(documentSnapshot.get("dept").toString());
                                txtSub6.setText(documentSnapshot.get("sub").toString());
                            }
                        }
                    });
                    break;

                case 7:
                    reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                documentSnapshot = task.getResult();
                                txtDept7.setText(documentSnapshot.get("dept").toString());
                                txtSub7.setText(documentSnapshot.get("sub").toString());
                            }
                        }
                    });
                    break;
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cd_1: openDialog(); clickFlag=1; break;
            case R.id.cd_2: openDialog(); clickFlag=2; break;
            case R.id.cd_3: openDialog(); clickFlag=3; break;
            case R.id.cd_4: openDialog(); clickFlag=4; break;
            case R.id.cd_5: openDialog(); clickFlag=5; break;
            case R.id.cd_6: openDialog(); clickFlag=6; break;
            case R.id.cd_7: openDialog(); clickFlag=7; break;
        }
    }
}
