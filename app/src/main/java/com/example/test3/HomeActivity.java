package com.example.test3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;


import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity  implements View.OnClickListener {
    private CardView searchv,periodev,helthv,alarmv,ambuv,scannerv,doctorsv,bmiv;

   // Toolbar toolbar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchv =findViewById(R.id.searchid);
        periodev =findViewById(R.id.period);
        helthv =findViewById(R.id.helthtips);
        alarmv =findViewById(R.id.alarm);
        ambuv =findViewById(R.id.ambulance);
        scannerv =findViewById(R.id.scanner);
        doctorsv =findViewById(R.id.doctorsref);
        bmiv =findViewById(R.id.bmi);


      //  androidx.appcompat.widget.Toolbar toolbar= findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
       // getSupportActionBar().setTitle("gjdcj");


        mAuth=FirebaseAuth.getInstance();///initialize firebase auth
        this.setTitle("Home Activity");
        searchv.setOnClickListener(this);
        periodev.setOnClickListener(this);
        helthv.setOnClickListener(this);
        alarmv.setOnClickListener(this);
        ambuv.setOnClickListener(this);
        scannerv.setOnClickListener(this);
        doctorsv.setOnClickListener(this);
        bmiv.setOnClickListener(this);
    }
    public  boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_layout, menu);
        return true;
    }

   /* public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.manu_layout,menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.signoutmenuid)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent =new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bmi :
                Intent intent=new Intent(HomeActivity.this,Bmi1Activity.class);
                startActivity(intent);
                break;
            case R.id.ambulance :
                intent = new Intent(HomeActivity.this, ZoneambulanceActivity.class);
                startActivity(intent);
                break;
            case R.id.doctorsref :
                intent = new Intent(HomeActivity.this, ZoneActivity.class);
                startActivity(intent);
                break;
            case R.id.searchid :
                intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.alarm :
                intent = new Intent(HomeActivity.this, AlarmActivity.class);
                startActivity(intent);
                break;
            case R.id.helthtips :
                intent = new Intent(HomeActivity.this, HealthActivity.class);
                startActivity(intent);
                break;
            case R.id.scanner :
                intent = new Intent(HomeActivity.this, Report.class);
                startActivity(intent);
                break;
            case R.id.period :
                intent = new Intent(HomeActivity.this, Period.class);
                startActivity(intent);
                break;






        }


    }

}
