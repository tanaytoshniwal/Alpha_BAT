package com.alphabat.guardians;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    EditText username,usermail,userpass,userpassc;
    Button spbutton,userbutton;
    TabHost host;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username=(EditText)findViewById(R.id.username);
        usermail=(EditText)findViewById(R.id.usermail);
        userpass=(EditText)findViewById(R.id.userpass);
        userpassc=(EditText)findViewById(R.id.userpassc);
        spbutton=(Button)findViewById(R.id.spbutton);
        userbutton=(Button)findViewById(R.id.userbutton);
        spbutton.setOnClickListener(SignupActivity.this);
        userbutton.setOnClickListener(SignupActivity.this);
        host=(TabHost)findViewById(R.id.th);host.setup();

        TabHost.TabSpec spec=host.newTabSpec("Tab one");
        spec.setContent(R.id.User);
        spec.setIndicator("Tab one");
        host.addTab(spec);

        spec=host.newTabSpec("Tab two");
        spec.setContent(R.id.Service_Provider);
        spec.setIndicator("Tab two");
        host.addTab(spec);
    }
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.spbutton:
            {
                Intent myIntent=new Intent(SignupActivity.this,Activity1.class);
                SignupActivity.this.startActivity(myIntent);
                finish();
                break;
            }
            case R.id.userbutton:
            {
                Intent myIntent=new Intent(SignupActivity.this,Activity1.class);
                SignupActivity.this.startActivity(myIntent);
                finish();
                break;
            }
        }
    }
}
