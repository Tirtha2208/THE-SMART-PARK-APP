package com.example.smartpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText phonetxt,emailtxt,fnametxt,lnametxt;
    Button regis,back;
    TextView responsetxt;
    RequestQueue queue;
    String email,phone,lname,fname;
    String url="http://localhost/smartpark/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        emailtxt=(EditText)findViewById(R.id.emailtxt);
        fnametxt=(EditText)findViewById(R.id.fnametxt);
        lnametxt=(EditText)findViewById(R.id.lnametxt);
        phonetxt=(EditText) findViewById(R.id.phonetxt);
        back=(Button)findViewById(R.id.back);
        regis=(Button)findViewById(R.id.regis);
        responsetxt=(TextView)findViewById(R.id.responsetxt);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=emailtxt.getText().toString();
                phone=phonetxt.getText().toString();
                fname=fnametxt.getText().toString();
                lname=lnametxt.getText().toString();

                queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                responsetxt.setText(String.format("%s", response));
                                emailtxt.setText("");
                                phonetxt.setText("");
                                fnametxt.setText("");
                                lnametxt.setText("");
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        responsetxt.setText(String.format("That didn't work! %s", error));
                    }
                })
                {
                    protected Map<String ,String> getParams()throws AuthFailureError
                    {
                        Map<String ,String> map = new HashMap<>();
                        map.put("email",email);
                        map.put("phone",phone);
                        map.put("fname",fname);
                        map.put("lname",lname);


                        return map;
                    }
                };
                queue.add(stringRequest);
                queue.start();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Registration.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
