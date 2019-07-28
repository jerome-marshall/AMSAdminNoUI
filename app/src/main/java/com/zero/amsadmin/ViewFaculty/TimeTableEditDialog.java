package com.zero.amsadmin.ViewFaculty;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.zero.amsadmin.R;

public class TimeTableEditDialog extends AppCompatDialogFragment {
    private EditText etDept;
    private EditText etSub;
    private TimeTableEditDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_tt_edit, null);

        builder.setView(view)
                .setTitle("Edit")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dept = etDept.getText().toString();
                        String sub = etSub.getText().toString();
                        listener.applyTexts(dept, sub);
                    }
                });

        etDept = view.findViewById(R.id.et_dialog_dept);
        etSub = view.findViewById(R.id.et_dialog_sub);

        return  builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (TimeTableEditDialogListener) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString() + "must implement Dialog Listener");
        }
    }

    public interface TimeTableEditDialogListener{
        void  applyTexts(String dept, String sub);
    }
}
