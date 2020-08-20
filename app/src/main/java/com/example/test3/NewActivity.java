package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import android.content.Intent;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
      //  ActionBar actionBar=getSupportActionBar();
        TextView mDetailTv= findViewById(R.id.textview);
        //get data from previous activity when item of list view is clicked intent
        Intent intent=getIntent();
        //String mActionBarTile=intent.getStringExtra("actionBarTitle");
        String mContent=intent.getStringExtra("contentTv");//Retrieve extended data from the intent.
        //set actionbar title
     //   actionBar.setTitle(mActionBarTile);
        //set text in textview
        mDetailTv.setText(mContent);
    }
}

