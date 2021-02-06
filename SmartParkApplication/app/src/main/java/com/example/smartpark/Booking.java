package com.example.smartpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Booking extends AppCompatActivity {

    Button back,carbook,bikebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        back=(Button)findViewById(R.id.back);
        carbook=(Button)findViewById(R.id.carbook);
        bikebook=(Button)findViewById(R.id.bikebook);

        carbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Booking.this, CarBook.class);
                startActivity(intent);
            }
        });

        bikebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Booking.this, BikeBook.class);
                startActivity(intent2);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Booking.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}