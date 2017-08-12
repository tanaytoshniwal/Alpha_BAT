package com.alphabat.guardians;

import android.app.ProgressDialog;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener{
    EditText username,password;
    Button button;
    Spinner spinner;
    String cat;
    int f1=0,f2=0;
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
                cat=cat.toLowerCase();
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
        final String id,pass;
        id=username.getText().toString();
        pass=password.getText().toString();
        if (id.equals("")) {
            username.setError("can't be blank");
        } else if (pass.equals("")) {
            password.setError("can't be blank");
        } else {
            String url = "https://alphabat-master1.firebaseio.com/alphabat-master1.json";
            final ProgressDialog pd = new ProgressDialog(SigninActivity.this);
            pd.setMessage("Loading...");
            pd.show();
            StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    if (s.equals("null")) {
                        Toast.makeText(SigninActivity.this, "user not found", Toast.LENGTH_LONG).show();
                    } else {
                        try
                        {
                            JSONObject obj = new JSONObject(s);
                            if(!obj.has(id))
                            {
                                Toast.makeText(SigninActivity.this, "user not found", Toast.LENGTH_LONG).show();
                            }
                            else if(!obj.getJSONObject(id).getString("category").equals(cat))
                            {
                                Toast.makeText(SigninActivity.this, "Wrong Category!", Toast.LENGTH_LONG).show();
                            }
                            else if(obj.getJSONObject(id).getString("password").equals(pass))
                            {
                                UserDetails.username = id;
                                UserDetails.password = pass;
                                if(obj.getJSONObject(id).getString("category").equals("service provider"))
                                    startActivity(new Intent(SigninActivity.this, ServiceProviderActivity.class));
                                else
                                    startActivity(new Intent(SigninActivity.this, UserActivity.class));
                            }
                            else
                                Toast.makeText(SigninActivity.this, "incorrect password", Toast.LENGTH_LONG).show();
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    pd.dismiss();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    System.out.println("" + volleyError);
                    pd.dismiss();
                }
            });RequestQueue rQueue = Volley.newRequestQueue(SigninActivity.this);
            rQueue.add(request);
        }
        /*if(id.equals("user")&&pass.equals("user"))
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
        }*/
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
