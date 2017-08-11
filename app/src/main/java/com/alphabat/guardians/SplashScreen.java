package com.alphabat.guardians;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    static int timeout=1000;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }

        },timeout);
        timeout=3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent=new Intent(SplashScreen.this,Activity1.class);
                SplashScreen.this.startActivity(myIntent);
                finish();
            }
        },timeout);
    }
}
