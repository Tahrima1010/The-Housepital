package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bmi3Activity extends AppCompatActivity  implements View. OnClickListener {
    TextView showtv1,showtv2;
    Button bu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi3);
        this.setTitle("BMI3 Activity");
        showtv1=(TextView) findViewById(R.id.text1);
        showtv2=(TextView) findViewById(R.id.text2);
        bu=(Button) findViewById(R.id.button);
        bu.setOnClickListener(this);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String bmiValue = bundle.getString("b");
            String height = bundle.getString("h");
            String weight = bundle.getString("w");
            Double bmi,h,w;
            bmi= Double.parseDouble(bmiValue);
            h = Double.parseDouble(height);
            w = Double.parseDouble(weight);
            bmiValue = String.format("%.1f",bmi);
            height = String.format("%.2f",h);
            weight = String.format("%.0f",w);

            if(bmi<18.5)
            {
                showtv1.setText("Height (in meters) :  " + height + "\n\nWeight (in KG): " + weight + "\n\nYour BMI is :" +bmiValue+ "\n\n\nYour Weight Status is Underweight");

            }
            else if(bmi>=18.5 && bmi<=24.9)
            {
                showtv1.setText("Height (in meters) : " + height + "\n\nWeight (in KG): " + weight + "\n\nYour BMI is :" +bmiValue+ "\n\n\nYour Weight Status is NORMAL");
            }
            else if(bmi>=25 && bmi<=29.9)
            {
                showtv1.setText("Height (in meters) : " + height + "\n\nWeight (in KG): " + weight + "\n\nYour BMI is :" +bmiValue+ "\n\n\nYour Weight Status is OVERWEIGHT");
            }
            else if(bmi>=30 && bmi<=34.9)
            {
                showtv1.setText("Height (in meters) : " + height + "\n\nWeight (in KG): " + weight + "\n\nYour BMI is :" +bmiValue+ "\n\nYour Weight Status is OBESE");
            }
            else
            {
                showtv1.setText("Height (in meters) : " + height + "\n\nWeight (in KG) :" + weight + "\n\nYour BMI is :" +bmiValue+ "\n\n\nYour Weight Status is EXTREMELY OBESE");
            }








        }
    }

    @Override
    public void onClick(View v) {
        Intent againcal=new Intent(Bmi3Activity.this,Bmi2Activity.class);
        startActivity(againcal);

    }
}
