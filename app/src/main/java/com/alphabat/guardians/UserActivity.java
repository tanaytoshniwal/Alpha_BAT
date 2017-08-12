package com.alphabat.guardians;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class UserActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2;
    RadioButton rb1,rb2,rb3;
    RadioGroup rg;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btn1=(Button)findViewById(R.id.btn1);
        rg=(RadioGroup)findViewById(R.id.rg) ;
        btn2=(Button)findViewById(R.id.btn2);
        btn1.setOnClickListener(UserActivity.this);
        btn2.setOnClickListener(UserActivity.this);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);
        rb3=(RadioButton)findViewById(R.id.rb3);
        name=(TextView)findViewById(R.id.name);
        name.setText("Hi,"+UserDetails.username);
    }
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btn1:
            {
                Intent myIntent=new Intent(UserActivity.this,ContactActivity.class);
                UserActivity.this.startActivity(myIntent);

                break;
            }
            case R.id.btn2:
            {
                if(rg.getCheckedRadioButtonId()==R.id.rb1)
                {
                    Intent myIntent=new Intent(UserActivity.this,MedicalService.class);
                    UserActivity.this.startActivity(myIntent);
                }
                else if(rg.getCheckedRadioButtonId()==R.id.rb2)
                {
                    Intent myIntent=new Intent(UserActivity.this,PoliceService.class);
                    UserActivity.this.startActivity(myIntent);
                }
                else if(rg.getCheckedRadioButtonId()==R.id.rb3)
                {
                    Intent myIntent=new Intent(UserActivity.this,FireService.class);
                    UserActivity.this.startActivity(myIntent);
                }
                else
                {
                    Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
