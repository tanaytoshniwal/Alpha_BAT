package com.alphabat.guardians;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TrustedContactActivity extends AppCompatActivity implements View.OnClickListener{
EditText phone;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trusted_contact);
        phone=(EditText)findViewById(R.id.phone);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(TrustedContactActivity.this);
    }
    @Override
    public void onClick(View view)
    {
        int number=Integer.parseInt(phone.getText().toString());
        Toast.makeText(this, "Number Updated!", Toast.LENGTH_SHORT).show();
    }

}
