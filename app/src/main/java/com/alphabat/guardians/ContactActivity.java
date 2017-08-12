package com.alphabat.guardians;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener{

  Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(ContactActivity.this);
    }
    @Override
    public void onClick(View view)
    {
        Toast.makeText(this, "Number Updated!", Toast.LENGTH_SHORT).show();
    }
}
