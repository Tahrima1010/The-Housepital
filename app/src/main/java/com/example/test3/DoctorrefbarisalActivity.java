package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class DoctorrefbarisalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorrefbarisal);
        TextView text= (TextView)findViewById(R.id.text6);
        TextView textt= (TextView)findViewById(R.id.text9);
        TextView textt1= (TextView)findViewById(R.id.text12);
        TextView textt2= (TextView)findViewById(R.id.text15);
        TextView textt3= (TextView)findViewById(R.id.text18);

        text.setMovementMethod(LinkMovementMethod.getInstance());
        textt.setMovementMethod(LinkMovementMethod.getInstance());//enable link
        textt1.setMovementMethod(LinkMovementMethod.getInstance());
        textt2.setMovementMethod(LinkMovementMethod.getInstance());
        textt3.setMovementMethod(LinkMovementMethod.getInstance());

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_layout,menu);
        return true;
    }
}
