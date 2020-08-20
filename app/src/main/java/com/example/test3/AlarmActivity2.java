package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AlarmActivity2 extends AppCompatActivity {
    private FloatingActionButton f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm2);
        f1 = (FloatingActionButton) findViewById(R.id.fab1);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlarmActivity4();
            }
        });
    }
    public void openAlarmActivity4(){
        Intent intent =new Intent(this,AlarmActivity4.class);
        startActivity(intent);
    }
}