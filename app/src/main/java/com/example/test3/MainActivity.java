package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation topanimation,bottomanimation;
    TextView logo,text;
    ImageView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int  SPLASH_SCREEN = 5000;//time 3 minit after show home page
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//hide actionbar
        setContentView(R.layout.activity_main);
        //call animation
        topanimation= AnimationUtils.loadAnimation( this,R.anim.top_animation);
        bottomanimation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        //hooks
        imageview=findViewById(R.id.image);
        //logo=findViewById(R.id.textView);
       // text=findViewById(R.id.textView4);

//assign animation
        imageview.setAnimation(topanimation);
        //text.setAnimation(bottomanimation);
        //logo.setAnimation(bottomanimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}
