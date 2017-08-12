package com.alphabat.guardians;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{
    EditText phone,address;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        button=(Button)findViewById(R.id.button);
        phone=(EditText)findViewById(R.id.phone);
        address=(EditText)findViewById(R.id.address);
        button.setOnClickListener(UpdateActivity.this);
    }
    @Override
    public void onClick(View view)
    {
        String phonea,addressa;
        phonea=phone.getText().toString();
        addressa=address.getText().toString();
        if(phonea.length()<10||phonea.length()>10)
        {
            Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
        }
        else
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this)
                    .setTitle("Data Updated!")
                    .setMessage("Your Contact Details are Updated Successfully")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent myIntent=new Intent(UpdateActivity.this,ServiceProviderActivity.class);
                            UpdateActivity.this.startActivity(myIntent);

                        }
                    })
                    ;
            alert.show();
        }
    }
}
