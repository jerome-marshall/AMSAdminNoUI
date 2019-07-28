package com.zero.amsadmin.ViewFaculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zero.amsadmin.Faculty;
import com.zero.amsadmin.R;

import java.util.List;

public class FacultyListAdapter extends RecyclerView.Adapter<FacultyListAdapter.ViewHolder> {

    public List<Faculty> facultyList;
    public Context context;

    public FacultyListAdapter(Context context, List<Faculty> facultyList){
        this.facultyList = facultyList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faculty_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(facultyList.get(position).getName());
        holder.txtEmail.setText(facultyList.get(position).getEmail());

        final String userId = facultyList.get(position).userId;

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FacultyDetailsActivity.class);
                intent.putExtra("USER_ID", userId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return facultyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtEmail;
        View mView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            txtName = mView.findViewById(R.id.txt_listItem_name);
            txtEmail = mView.findViewById(R.id.txt_listItem_email);
        }
    }
}
