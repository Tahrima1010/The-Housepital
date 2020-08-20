package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Mother_child extends AppCompatActivity {

    private ListView listview;
    private String[] motherchild;
    private int[] pics = {R.drawable.covid, R.drawable.symptos, R.drawable.problem, R.drawable.eating, R.drawable.physicalactivity, R.drawable.delivery, R.drawable.babycare};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_child);
        motherchild = getResources().getStringArray(R.array.mother_child);

        listview = (ListView) findViewById(R.id.listviewid);


        CustomView1 adapter= new CustomView1(this,motherchild,pics);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent = new Intent(Mother_child.this,parenting.class);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent = new Intent(Mother_child.this,symptoms.class);
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent = new Intent(Mother_child.this,problem.class);
                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent = new Intent(Mother_child.this,health_eating.class);
                    startActivity(intent);
                }
                if(position==4)
                {
                    Intent intent = new Intent(Mother_child.this,physical.class);
                    startActivity(intent);
                }
                if(position==5)
                {
                    Intent intent = new Intent(Mother_child.this,delivery.class);
                    startActivity(intent);
                }
                if(position==6)
                {
                    Intent intent = new Intent(Mother_child.this,babycare.class);
                    startActivity(intent);
                }




            }
        });


    }
}