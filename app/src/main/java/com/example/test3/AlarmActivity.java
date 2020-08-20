package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity {
    private Button pill;
    private Button water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        pill = (Button) findViewById(R.id.b);
        pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlarmActivity2();
            }
        });
        water = (Button) findViewById(R.id.b1);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlarmActivity3();
            }
        });

    }
    public void openAlarmActivity2(){
        Intent intent =new Intent(this,AlarmActivity2.class);
        startActivity(intent);
        Toast myToast = Toast.makeText(this, "Set  reminder for drinking water", Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void openAlarmActivity3(){
        Intent intent =new Intent(this,AlarmActivity3.class);
        startActivity(intent);

        Toast myToast = Toast.makeText(this, "Set reminder for medicines", Toast.LENGTH_SHORT);
        myToast.show();
    }


}