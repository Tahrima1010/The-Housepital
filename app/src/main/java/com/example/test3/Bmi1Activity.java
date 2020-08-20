package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bmi1Activity extends AppCompatActivity implements View.OnClickListener {
    private Button startbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi1);
        this.setTitle("BMI1 Activity");
        startbtn=(Button) findViewById(R.id.button);
        startbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Bmi1Activity.this,Bmi2Activity.class);
        startActivity(intent);

    }
}
