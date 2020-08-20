package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlarmActivity4 extends AppCompatActivity {
    EditText hour;
    EditText minute;
    Button reminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm4);
        hour=(EditText)findViewById(R.id.ed1);
        minute=(EditText)findViewById(R.id.ed2);
        reminder=(Button)findViewById(R.id.button);
        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int h=Integer.parseInt(hour.getText().toString());
                int m=Integer.parseInt(minute.getText().toString());
                Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,h);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,m);
                if(h<=24 && m<=60){
                    startActivity(intent);
                }
            }
        });
    }
}
