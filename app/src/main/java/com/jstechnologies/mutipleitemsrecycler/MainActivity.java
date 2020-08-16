package com.jstechnologies.mutipleitemsrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jstechnologies.mutipleitemsrecycler.Adapters.MultiAdapter;
import com.jstechnologies.mutipleitemsrecycler.Models.Admin;
import com.jstechnologies.mutipleitemsrecycler.Models.Faculty;
import com.jstechnologies.mutipleitemsrecycler.Models.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MultiAdapter adapter;
    ArrayList<Object> list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadData();
        recyclerView=findViewById(R.id.recycler);
        adapter=new MultiAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);

    }
    void LoadData()
    {
        for(int i=0; i<5;i++)
        {
            Student obj=new Student();
            obj.setName("Student"+i);
            obj.setRole("STUDENT");
            obj.setPercentage("82%");
            list.add(obj);


            Faculty obj1=new Faculty();
            obj1.setName("Faculty"+i);
            obj1.setRole("FACULTY");
            obj1.setSubject("ENGLISH");
            obj1.setSalary("Rs 50,000");
            list.add(obj1);

            Admin obj2=new Admin();
            obj2.setName("Admin"+i);
            obj2.setRole("ADMIN");
            obj2.setAccesstoken("tk1234567890");
            obj1.setSalary("Rs 50,000");
            list.add(obj2);

        }
    }
}