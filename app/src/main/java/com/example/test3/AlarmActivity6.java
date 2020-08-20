package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class AlarmActivity6 extends AppCompatActivity {

    TimePicker timepicker;
    TextView textview;
    int Hour;
    int Min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm6);
        timepicker=(TimePicker)findViewById(R.id.tp1);
        textview=(TextView)findViewById(R.id.tv1);
        timepicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourofday, int minute) {
                Hour=hourofday;
                Min=minute;
                textview.setText(textview.getText().toString()+ " " + Hour+ ":" + Min);

            }
        });
    }
    public void setTimer(View v) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Date date = new Date();
        Calendar cal_alarm = Calendar.getInstance();
        Calendar cal_now = Calendar.getInstance();
        cal_now.setTime(date);
        cal_alarm.setTime(date);

        cal_alarm.set(Calendar.HOUR_OF_DAY, Hour);
        cal_alarm.set(Calendar.MINUTE, Min);
        cal_alarm.set(Calendar.SECOND, 0);
        if (cal_alarm.before(cal_now)) {
            cal_alarm.add(Calendar.DATE, 1);
        }
        Intent i=new Intent(AlarmActivity6.this,MyBroadcastReciever.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(AlarmActivity6.this,2444,i,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,cal_alarm.getTimeInMillis(),pendingIntent);


    }}
