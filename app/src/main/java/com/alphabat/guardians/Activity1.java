package com.alphabat.guardians;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity implements View.OnClickListener{
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(Activity1.this);
        button2.setOnClickListener(Activity1.this);
    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button1:
            {
                Intent myIntent=new Intent(Activity1.this,SigninActivity.class);
                Activity1.this.startActivity(myIntent);
                break;
            }
            case R.id.button2:
            {
                Intent myIntent=new Intent(Activity1.this,SignupActivity.class);
                Activity1.this.startActivity(myIntent);
                finish();
                break;
            }
        }
    }
}
