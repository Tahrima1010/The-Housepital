package com.example.test3;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AmbulanceActivity extends AppCompatActivity {
    // private static int REQUEST_CALL = 0;
    private Button callbutton, callbutton1, callbutton2, callbutton3, callbutton4, callbutton5, callbutton6, callbutton7, callbutton8,
            callbutton9;
    private TextView text, hospitext, hospitext1, hospitext2, hospitext3, hospitext4, hospitext5, hospitext6, hospitext7, hospitext8, hospitext9, textt1,
            textt2, textt3, textt4, textt5, textt6, textt7, textt8, textt9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);
        callbutton = findViewById(R.id.callbutton);
        callbutton1 = findViewById(R.id.callbutton1);
        callbutton2= findViewById(R.id.callbutton2);
        callbutton3 = findViewById(R.id.callbutton3);
        callbutton4 = findViewById(R.id.callbutton4);
        callbutton5 = findViewById(R.id.callbutton5);
        callbutton6 = findViewById(R.id.callbutton6);
        callbutton7 = findViewById(R.id.callbutton7);
        callbutton8 = findViewById(R.id.callbutton8);
        callbutton9 = findViewById(R.id.callbutton9);

        text = findViewById(R.id.text2);
        textt1 = findViewById(R.id.text4);
        textt2 = findViewById(R.id.text6);
        textt3 = findViewById(R.id.text8);
        textt4 = findViewById(R.id.text10);
        textt6 = findViewById(R.id.text14);
        textt7 = findViewById(R.id.text16);
        textt8 = findViewById(R.id.text18);
        textt9 = findViewById(R.id.text20);


        hospitext = findViewById(R.id.text1);
        hospitext1 = findViewById(R.id.text3);
        hospitext2 = findViewById(R.id.text5);
        hospitext3 = findViewById(R.id.text7);
        hospitext4 = findViewById(R.id.text9);
        hospitext5 = findViewById(R.id.text11);
        hospitext6 = findViewById(R.id.text13);
        hospitext7 = findViewById(R.id.text15);
        hospitext8 = findViewById(R.id.text17);
        hospitext9 = findViewById(R.id.text19);

        callbutton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + text.getText().toString()));//resource
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    return;
                }
                startActivity(i);
            }
        });
        callbutton1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + textt1.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                    return;
                startActivity(i);
            }
        });
        callbutton2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + textt2.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //ActivityCompat.requestPermissions(AmbulanceActivity.this,new String[]{Manifest.permission.CALL_PHONE},0);



                   return;
                }//else
               // {
                    startActivity(i);
                //}

            }
        });
        callbutton3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + textt3.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(i);
            }
        });
        callbutton4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + textt4.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(i);
            }
        });
        callbutton5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + textt5.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(i);
            }
        });
        callbutton6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + textt6.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(i);
            }
        });
        callbutton7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + textt7.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(i);
            }
        });
        callbutton8.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + textt8.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(i);
            }
        });
        callbutton9.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + textt9.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(i);
            }
        });

    }



}

