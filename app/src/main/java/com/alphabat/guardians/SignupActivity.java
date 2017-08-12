package com.alphabat.guardians;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.Firebase;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    EditText username,usermail,userpass,userpassc;
    EditText spname,spmail,sppass,sppassc;
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
        spname=(EditText)findViewById(R.id.spname);
        spmail=(EditText)findViewById(R.id.spmail);
        sppass=(EditText)findViewById(R.id.sppass);
        sppassc=(EditText)findViewById(R.id.sppassc);
        spbutton=(Button)findViewById(R.id.spbutton);
        userbutton=(Button)findViewById(R.id.userbutton);
        spbutton.setOnClickListener(SignupActivity.this);
        userbutton.setOnClickListener(SignupActivity.this);
        host=(TabHost)findViewById(R.id.th);host.setup();
        spname.setText("");
        TabHost.TabSpec spec=host.newTabSpec("User");
        spec.setContent(R.id.User);
        spec.setIndicator("User");
        host.addTab(spec);
        Firebase.setAndroidContext(this);
        spec=host.newTabSpec("Service Provider");
        spec.setContent(R.id.Service_Provider);
        spec.setIndicator("Service Provider");
        host.addTab(spec);
    }
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.spbutton:
            {/*
                Intent myIntent=new Intent(SignupActivity.this,Activity1.class);
                SignupActivity.this.startActivity(myIntent);
                finish();*/
                final String spname1,spmail1,sppass1,sppassc1;
                spname1=spname.getText().toString();
                spmail1=spmail.getText().toString();
                sppass1=sppass.getText().toString();
                sppassc1=sppassc.getText().toString();
                if(sppass1.equals(sppassc1)) {
                    if (spname1.equals("")) {
                        spname.setError("can't be blank");
                    } else if (sppass1.equals("")) {
                        sppass.setError("can't be blank");
                    } else if (spmail1.equals("")) {
                        spmail.setError("can't be blank");
                    }
                    else
                    {
                        final ProgressDialog pd = new ProgressDialog(SignupActivity.this);
                        pd.setMessage("Loading...");
                        pd.show();
                        String url="https://alphabat-master1.firebaseio.com/alphabat-master1.json";
                        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                            @Override
                            public void onResponse(String s) {
                                Firebase reference = new Firebase("https://alphabat-master1.firebaseio.com/alphabat-master1");

                                if(s.equals("null")) {
                                    reference.child(spname1).child("password").setValue(sppass1);
                                    reference.child(spname1).child("mail").setValue(spmail1);
                                    reference.child(spname1).child("category").setValue("service provider");
                                    Toast.makeText(SignupActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    try {
                                        JSONObject obj = new JSONObject(s);

                                        if (!obj.has(spname1)) {
                                            reference.child(spname1).child("password").setValue(sppass1);
                                            reference.child(spname1).child("mail").setValue(spmail1);
                                            reference.child(spname1).child("category").setValue("service provider");
                                            Toast.makeText(SignupActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(SignupActivity.this, "username already exists", Toast.LENGTH_LONG).show();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                pd.dismiss();
                            }

                        },new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                System.out.println("" + volleyError );
                                pd.dismiss();
                            }
                        });
                        RequestQueue rQueue = Volley.newRequestQueue(SignupActivity.this);
                        rQueue.add(request);
                    }
                }
                else
                {
                    Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.userbutton:
            {/* Intent myIntent=new Intent(SignupActivity.this,Activity1.class);
                SignupActivity.this.startActivity(myIntent);
                finish();*/
                final String username1,usermail1,userpass1,userpassc1;
                username1=username.getText().toString();
                usermail1=usermail.getText().toString();
                userpass1=userpass.getText().toString();
                userpassc1=userpassc.getText().toString();
                if(userpass1.equals(userpassc1)) {
                    if (username1.equals("")) {
                        spname.setError("can't be blank");
                    } else if (userpass1.equals("")) {
                        sppass.setError("can't be blank");
                    } else if (usermail1.equals("")) {
                        spmail.setError("can't be blank");
                    }
                    else
                    {
                        final ProgressDialog pd = new ProgressDialog(SignupActivity.this);
                        pd.setMessage("Loading...");
                        pd.show();
                        String url="https://alphabat-master1.firebaseio.com/alphabat-master1.json";
                        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                            @Override
                            public void onResponse(String s) {
                                Firebase reference = new Firebase("https://alphabat-master1.firebaseio.com/alphabat-master1");

                                if(s.equals("null")) {
                                    reference.child(username1).child("password").setValue(userpass1);
                                    reference.child(username1).child("mail").setValue(usermail1);
                                    reference.child(username1).child("category").setValue("user");
                                    Toast.makeText(SignupActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    try {
                                        JSONObject obj = new JSONObject(s);

                                        if (!obj.has(username1)) {
                                            reference.child(username1).child("password").setValue(userpass1);
                                            reference.child(username1).child("mail").setValue(usermail1);
                                            reference.child(username1).child("category").setValue("user");
                                            Toast.makeText(SignupActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(SignupActivity.this, "username already exists", Toast.LENGTH_LONG).show();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                pd.dismiss();
                            }

                        },new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                System.out.println("" + volleyError );
                                pd.dismiss();
                            }
                        });
                        RequestQueue rQueue = Volley.newRequestQueue(SignupActivity.this);
                        rQueue.add(request);
                    }
                }
                else
                {
                    Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
