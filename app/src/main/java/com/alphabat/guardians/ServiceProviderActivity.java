package com.alphabat.guardians;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;

public class ServiceProviderActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    Switch s;
    CheckBox rb1,rb2,rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider);
        button=(Button)findViewById(R.id.button);
        s=(Switch)findViewById(R.id.s);
        rb1=(CheckBox)findViewById(R.id.rb1);
        rb2=(CheckBox)findViewById(R.id.rb2);
        rb3=(CheckBox)findViewById(R.id.rb3);
        button.setOnClickListener(ServiceProviderActivity.this);
    }
    @Override
    public void onClick(View view)
    {
        AlertDialog.Builder alert=new AlertDialog.Builder(this)
                .setTitle("Data Updated!")
                .setMessage("Do you wish to update your contact details as well?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent myIntent=new Intent(ServiceProviderActivity.this,UpdateActivity.class);
                        ServiceProviderActivity.this.startActivity(myIntent);

                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,int i){
                        dialogInterface.cancel();
                    }
                });
        alert.show();
    }
}
