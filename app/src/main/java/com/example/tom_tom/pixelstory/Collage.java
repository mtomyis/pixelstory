package com.example.tom_tom.pixelstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tom_tom.pixelstory.FrameSaja.Lay2;
import com.example.tom_tom.pixelstory.FrameText.Lay1T;

public class Collage extends AppCompatActivity {

    Button vbtnlay_1, vbtnlay_2,vbtnlay_3,vbtnlay_4,vbtnlay_5,
            vbtnlay_6,vbtnlay_7,vbtnlay_8,vbtnlay_9,vbtnlay_10,
            vbtnlay_11,vbtnlay_12,vbtnlay_13,vbtnlay_14,vbtnlay_15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collage);

        //menyambungkan dr variabel ke layout
        vbtnlay_1 = (Button) findViewById(R.id.btn_lay1);
        vbtnlay_2 = (Button) findViewById(R.id.btn_lay2);
        vbtnlay_3 = (Button) findViewById(R.id.btn_lay3);
        vbtnlay_4 = (Button) findViewById(R.id.btn_lay4);
        vbtnlay_5 = (Button) findViewById(R.id.btn_lay5);
        vbtnlay_6 = (Button) findViewById(R.id.btn_lay6);
        vbtnlay_7 = (Button) findViewById(R.id.btn_lay7);
        vbtnlay_8 = (Button) findViewById(R.id.btn_lay8);
        vbtnlay_9 = (Button) findViewById(R.id.btn_lay9);
        vbtnlay_10 = (Button) findViewById(R.id.btn_lay10);
        vbtnlay_11 = (Button) findViewById(R.id.btn_lay11);
        vbtnlay_12 = (Button) findViewById(R.id.btn_lay12);
        vbtnlay_13 = (Button) findViewById(R.id.btn_lay13);
        vbtnlay_14 = (Button) findViewById(R.id.btn_lay14);
        vbtnlay_15 = (Button) findViewById(R.id.btn_lay15);

        vbtnlay_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), Lay2.class);
                finish();
                startActivity(i);

            }
        });

        vbtnlay_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Lay1T.class);
                finish();
                startActivity(i);
            }
        });

        vbtnlay_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vbtnlay_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
