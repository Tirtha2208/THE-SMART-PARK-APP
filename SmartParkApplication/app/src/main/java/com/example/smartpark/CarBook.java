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

public class CarBook extends AppCompatActivity {


    EditText emailtxt,phonetxt,carnotxt,datetxt,timetxt,cidtxt;
    Button bookbtn,backbtn;
    String url="http://localhost/smartpark/insertcar.php";
    TextView responsetxt;
    RequestQueue queue;
    String email,phone,carno,date,time,cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_book);
        cidtxt=(EditText)findViewById(R.id.cidtxt);
        emailtxt=(EditText)findViewById(R.id.emailtxt);
        phonetxt=(EditText)findViewById(R.id.phonetxt);
        carnotxt=(EditText)findViewById(R.id.carnotxt);
        datetxt=(EditText)findViewById(R.id.datetxt);
        timetxt=(EditText)findViewById(R.id.timetxt);
        responsetxt=(TextView)findViewById(R.id.responsetxt);
        bookbtn=(Button)findViewById(R.id.bookbtn);
        backbtn=(Button)findViewById(R.id.backbtn);


        bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cid=cidtxt.getText().toString();
                email=emailtxt.getText().toString();
                phone=phonetxt.getText().toString();
                carno=carnotxt.getText().toString();
                date=datetxt.getText().toString();
                time=timetxt.getText().toString();
                queue = Volley.newRequestQueue(getApplicationContext());

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                responsetxt.setText(String.format("%s", response));
                                emailtxt.setText("");
                                phonetxt.setText("");
                                carnotxt.setText("");
                                datetxt.setText("");
                                cidtxt.setText("");
                                timetxt.setText("");
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
                        map.put("id",cid);
                        map.put("email",email);
                        map.put("phone",phone);
                        map.put("carno",carno);
                        map.put("date",date);
                        map.put("time",time);

                        return map;
                    }
                };
                // Add the request to the RequestQueue.
                queue.add(stringRequest);
                queue.start();

            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarBook.this, Booking.class);
                startActivity(intent);
            }
        });
    }
}
