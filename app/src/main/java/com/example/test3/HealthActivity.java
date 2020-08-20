package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HealthActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView motherchildv, firstaidv, foodv, exercisev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        motherchildv = findViewById(R.id.motherchildid);
        firstaidv = findViewById(R.id.firstaidid);
        foodv = findViewById(R.id.foodnutrationid);
        exercisev = findViewById(R.id.exerciseid);

        motherchildv.setOnClickListener(this);
        firstaidv.setOnClickListener(this);
        foodv.setOnClickListener(this);
        exercisev.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()) {

            case R.id.motherchildid:
                i = new Intent(this, Mother_child.class);
                startActivity(i);
                break;
            case R.id.firstaidid:
                i = new Intent(this, Firstaid.class);
                startActivity(i);
                break;
            case R.id.foodnutrationid:
                i = new Intent(this, food_nutrition.class);
                startActivity(i);
                break;
            case R.id.exerciseid:
                i = new Intent(this, exercise.class);
                startActivity(i);
                break;
            default:
                break;


        }
    }
}