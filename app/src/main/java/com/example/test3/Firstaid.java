package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Firstaid extends AppCompatActivity {

    private ListView listview;
    private String[] firstaid;
    private int[] image= {R.drawable.fracture, R.drawable.fire, R.drawable.breath, R.drawable.waterdive, R.drawable.handcut};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid);
        firstaid = getResources().getStringArray(R.array.first_aiddes);

        listview = (ListView) findViewById(R.id.listviewid);



        CustomView2 adapter = new CustomView2(this,firstaid,image);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent = new Intent(Firstaid.this,fructureActivity.class);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent = new Intent(Firstaid.this,burnActivity.class);
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent = new Intent(Firstaid.this,breathActivity.class);
                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent = new Intent(Firstaid.this,waterDrawn.class);
                    startActivity(intent);
                }
                if(position==4)
                {
                    Intent intent = new Intent(Firstaid.this,cutActivity.class);
                    startActivity(intent);
                }




            }
        });
    }
}