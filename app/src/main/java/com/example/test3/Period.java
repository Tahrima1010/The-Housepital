package com.example.test3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Period extends AppCompatActivity {
    private FloatingActionButton f1;
    private Button detailsbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period);
        f1 = (FloatingActionButton) findViewById(R.id.fab1);
        detailsbutton = (Button) findViewById(R.id.bitperiod);



            detailsbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openPeriod3();
                }
            });

           f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openPeriod2();
                }
            });

        }
        public void openPeriod3(){
            Intent intent =new Intent(this,Period3.class);
            startActivity(intent);

        }
        public void openPeriod2(){
            Intent intent =new Intent(this,Period2.class);
            startActivity(intent);


        }

}









