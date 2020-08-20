package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AlarmActivity5 extends AppCompatActivity

    {
        Button but;
        EditText N;
        EditText D;
        Button save;
        DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm5);
        databaseReference= FirebaseDatabase.getInstance().getReference("Medicines");
        but=(Button)findViewById(R.id.button2);
        save=(Button)findViewById(R.id.buttonsave);

        N=(EditText) findViewById(R.id.ed3);
        D=(EditText) findViewById(R.id.ed4);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AlarmActivity5.this,AlarmActivity3.class);
                startActivity(intent);
            }
        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlarmActivity6();
                saveData();
            }


        });

    } public void openAlarmActivity6(){
        Intent intent= new Intent(this,AlarmActivity6.class);
        startActivity(intent);
    }
        public void saveData()
        {
            String name=N.getText().toString().trim();
            String dose=D.getText().toString().trim();
            String key=databaseReference.push().getKey();
            Medicine medicine=new Medicine(name,dose);
            databaseReference.child(key).setValue(medicine);
            Toast.makeText(getApplicationContext(),"Info added",Toast.LENGTH_LONG).show();
            N.setText("");
            D.setText("");
        }
    }
