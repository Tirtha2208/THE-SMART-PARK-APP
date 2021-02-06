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

public class Balance extends AppCompatActivity {

    EditText cidtxt;
    Button balan,back;
    TextView responsetxt;
    RequestQueue queue;
    String cid;
    String url="http://localhost/smartpark/balance.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        cidtxt=(EditText)findViewById(R.id.cidtxt);
        back=(Button)findViewById(R.id.back);
        balan=(Button)findViewById(R.id.balan);
        responsetxt=(TextView)findViewById(R.id.responsetxt);

        balan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cid=cidtxt.getText().toString();

                queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                responsetxt.setText(String.format("%s", response));
                                cidtxt.setText("");
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
                        map.put("cno",cid);

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
                Intent intent2 = new Intent(Balance.this, MainActivity.class);
                startActivity(intent2);
            }
        });

    }
}
