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

public class Exit extends AppCompatActivity {

    EditText typetxt,idtxt,emailtxt;
    Button exit,back;
    TextView responsetxt;
    RequestQueue queue;
    String email,id,type;
    String url="http://localhost/smartpark/alter.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        typetxt=(EditText)findViewById(R.id.typetxt);
        idtxt=(EditText)findViewById(R.id.idtxt);
        emailtxt=(EditText)findViewById(R.id.emailtxt);
        exit=(Button)findViewById(R.id.exit);
        back=(Button)findViewById(R.id.back);
        responsetxt=(TextView)findViewById(R.id.responsetxt);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=emailtxt.getText().toString();
                id=idtxt.getText().toString();
                type=typetxt.getText().toString();


                queue = Volley.newRequestQueue(getApplicationContext());

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                responsetxt.setText(String.format("%s", response));
                                emailtxt.setText("");
                                typetxt.setText("");
                                idtxt.setText("");
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
                        map.put("type",type);
                        map.put("id",id);

                        return map;
                    }
                };
                // Add the request to the RequestQueue.
                queue.add(stringRequest);
                queue.start();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Exit.this, MainActivity.class);
                startActivity(intent2);
            }
        });

    }
}
