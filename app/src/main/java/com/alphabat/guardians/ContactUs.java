package com.alphabat.guardians;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactUs extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener{
    Button button;
    EditText email,to,message;
    int f1=0,f2=0,f3=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        button=(Button)findViewById(R.id.button);
        email=(EditText)findViewById(R.id.email);
        to=(EditText)findViewById(R.id.to);
        message=(EditText)findViewById(R.id.message);
        button.setOnClickListener(ContactUs.this);
        email.setOnFocusChangeListener(ContactUs.this);
        to.setOnFocusChangeListener(ContactUs.this);
        message.setOnFocusChangeListener(ContactUs.this);
    }
    @Override
    public void onClick(View view)
    {

    }
    @Override
    public void onFocusChange(View view,boolean b)
    {
        switch(view.getId())
        {
            case R.id.email:
            {
                if(f1==0)
                {
                    email.setText("");f1++;
                }
                break;
            }
            case R.id.to:
            {
                if(f2==0)
                {
                    to.setText("");
                    f2++;
                }
                break;
            }
            case R.id.message:
            {
                if(f3==0)
                {
                    message.setText("" );
                    f3++;
                }
                break;
            }
        }
    }
}
