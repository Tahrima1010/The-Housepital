package com.example.test3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AlarmActivity3 extends AppCompatActivity {
    private FloatingActionButton f2;
    ListView list;
    private List<Medicine> medicineList;
    private CustomAdapter customAdapter;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm3);
        list=(ListView)findViewById(R.id.medicinelist);
        databaseReference= FirebaseDatabase.getInstance().getReference("Medicines");
        medicineList=new ArrayList<>();
        customAdapter=new CustomAdapter(AlarmActivity3.this,medicineList);




        f2 = (FloatingActionButton) findViewById(R.id.fab2);
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlarmActivity5();
            }
        });
    }
    public void openAlarmActivity5(){
        Intent intent =new Intent(this,AlarmActivity5.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                medicineList.clear();;
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Medicine medicine=dataSnapshot1.getValue(Medicine.class);
                    medicineList.add(medicine);
                }
                list.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}