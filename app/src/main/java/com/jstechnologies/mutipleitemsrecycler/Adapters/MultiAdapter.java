package com.jstechnologies.mutipleitemsrecycler.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jstechnologies.mutipleitemsrecycler.Models.Admin;
import com.jstechnologies.mutipleitemsrecycler.Models.Faculty;
import com.jstechnologies.mutipleitemsrecycler.Models.Student;
import com.jstechnologies.mutipleitemsrecycler.R;

import java.util.ArrayList;

public class MultiAdapter extends RecyclerView.Adapter {

    ArrayList<Object>models;
    final static int STUDENT_VIEW=1;
    final static int FACULTY_VIEW=2;
    final static int ADMIN_VIEW=3;

    public MultiAdapter(ArrayList<Object> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType)
        {
            case STUDENT_VIEW:return new StudentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student,parent,false));
            case ADMIN_VIEW:return new AdminHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_admin,parent,false));
            default:return new FacultyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faculty,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(models.get(position) instanceof Admin)
            ((AdminHolder)holder).Bind((Admin)models.get(position));
        if(models.get(position) instanceof Student)
            ((StudentHolder)holder).Bind((Student) models.get(position));
        if(models.get(position) instanceof Faculty)
            ((FacultyHolder)holder).Bind((Faculty) models.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if(models.get(position)instanceof Student)
            return STUDENT_VIEW;
        else if(models.get(position)instanceof Admin)
            return ADMIN_VIEW;
        else
            return FACULTY_VIEW;
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        TextView name,role,percent;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            role=itemView.findViewById(R.id.role);
            percent=itemView.findViewById(R.id.percent);
        }
        public void Bind(Student model)
        {
            name.setText(model.getName());
            role.setText(model.getRole());
            percent.setText(model.getPercentage());
        }
    }
    public class FacultyHolder extends RecyclerView.ViewHolder {
        LinearLayout round;
        TextView name,role,subject,salary;
        public FacultyHolder(@NonNull View itemView) {
            super(itemView);
            round=itemView.findViewById(R.id.round);
            name=itemView.findViewById(R.id.name);
            role=itemView.findViewById(R.id.role);
            subject=itemView.findViewById(R.id.subject);
            salary=itemView.findViewById(R.id.salary);
        }
        public void Bind(Faculty model)
        {
            name.setText(model.getName());
            role.setText(model.getRole());
            subject.setText(model.getSubject());
            salary.setText(model.getSalary());
        }
    }
    public class AdminHolder extends RecyclerView.ViewHolder {
        LinearLayout round;
        TextView name,role,accesstoken;
        public AdminHolder(@NonNull View itemView) {
            super(itemView);
            round=itemView.findViewById(R.id.round);
            name=itemView.findViewById(R.id.name);
            role=itemView.findViewById(R.id.role);
            accesstoken=itemView.findViewById(R.id.accesstoken);
        }
        public void Bind(Admin model)
        {
            name.setText(model.getName());
            role.setText(model.getRole());
            accesstoken.setText(model.getAccesstoken());
        }

    }
}
