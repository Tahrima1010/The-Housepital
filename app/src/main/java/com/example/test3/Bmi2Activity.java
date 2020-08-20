package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bmi2Activity extends AppCompatActivity  implements View.OnClickListener {
    Button b;
    EditText et1, et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi2);
        this.setTitle("BMI2 Activity");
        b = (Button) findViewById(R.id.b1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et10);

        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double w, h1, h2, h, m, bmi;
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();
        String s3 = et3.getText().toString();

        if(!s1.isEmpty() && !s2.isEmpty() &&  !s3.isEmpty() )
        {
            try
            {
                w = Float.parseFloat(s1);
                h1 = Float.parseFloat(s2);
                h2 =Float.parseFloat(s3);

                h = ((h1 * 12) + h2);
                m = h * 0.0254;
                bmi = w / (m * m);
                String bmiValue = "" + bmi;
                String height = "" + m;
                String weight = "" + w;
                Intent i = new Intent(Bmi2Activity.this, Bmi3Activity.class);
                i.putExtra("b", bmiValue);
                i.putExtra("h", height);
                i.putExtra("w", weight);

                startActivity(i);
            }
            catch (Exception e)
            {
                Toast.makeText(this,"You haven't entered correct values", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"You haven't given all parameters", Toast.LENGTH_LONG).show();
        }
    }
}




