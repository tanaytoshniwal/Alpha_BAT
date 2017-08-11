package com.alphabat.guardians;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener{
    EditText username,password;
    Button button;
    Spinner spinner;
    String cat;
    static int f1=0,f2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username=(EditText)findViewById(R.id.username);
        username.setOnFocusChangeListener(SigninActivity.this);
        password=(EditText)findViewById(R.id.password);
        password.setOnFocusChangeListener(SigninActivity.this);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(SigninActivity.this);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cat=spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view)
    {
        String id,pass;
        id=username.getText().toString();
        pass=password.getText().toString();
        if(id.equals("user")&&pass.equals("user"))
        {
            if(cat.equals("User"))
            {
                Toast.makeText(this, "Verified!", Toast.LENGTH_SHORT).show();
                Intent myIntent=new Intent(SigninActivity.this,UserActivity.class);
                SigninActivity.this.startActivity(myIntent);
                finish();
            }
            else if(cat.equals("Service Provider"))
            {
                Toast.makeText(this, "Verified!", Toast.LENGTH_SHORT).show();
                Intent myIntent=new Intent(SigninActivity.this,ServiceProviderActivity.class);
                SigninActivity.this.startActivity(myIntent);
                finish();
            }
        }
        else
        {
            Toast.makeText(this, "Wrong Credentials!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b==true)
        {
            switch(view.getId())
            {
                case R.id.username:
                {
                    if(f1==0)
                    {
                        username.setText("");f1++;
                    }
                    break;
                }
                case R.id.password:
                {
                    if(f2==0)
                    {
                        password.setText("");f2++;
                    }
                    break;
                }
            }
        }
    }
}
