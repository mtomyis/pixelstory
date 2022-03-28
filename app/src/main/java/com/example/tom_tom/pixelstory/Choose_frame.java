package com.example.tom_tom.pixelstory;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.tom_tom.pixelstory.Fragments.Framesaja;
import com.example.tom_tom.pixelstory.Fragments.Frametext;

public class Choose_frame extends FragmentActivity implements View.OnClickListener {
    Button vbtnframesaja, vbtnframetext, vbtnback;
    Framesaja framesaja;
    Frametext frametext;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_frame);

        vbtnframesaja=(Button)findViewById(R.id.btnpilihframesaja);
        vbtnframetext=(Button)findViewById(R.id.btnpilihframedantext);
        vbtnback=(Button)findViewById(R.id.btnkembali);

        vbtnframesaja.setOnClickListener(this);
        vbtnframetext.setOnClickListener(this);

        fragmentutama();

        vbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Choose_frame.this, MainActivity.class);
                finish();
                startActivity(i);

            }
        });

        //hidupkan button ketika klik
        vbtnframesaja.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    vbtnframesaja.setBackgroundColor(Color.DKGRAY);
                    vbtnframetext.setBackgroundColor(Color.TRANSPARENT);
                }
                return false;
            }

        });

        //hidupkan button ketika klik
        vbtnframetext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    vbtnframetext.setBackgroundColor(Color.DKGRAY);
                    vbtnframesaja.setBackgroundColor(Color.TRANSPARENT);
                }
                return false;
            }

        });

    }

    private void fragmentutama() {
        FragmentTransaction ftr = getSupportFragmentManager().beginTransaction();
        framesaja = new Framesaja();
        vbtnframesaja.setBackgroundColor(Color.DKGRAY);
        ftr.replace(R.id.container,framesaja);
        ftr.commit();
    }


    void pindahframsaja(){
        FragmentTransaction ftr = getSupportFragmentManager().beginTransaction();
        framesaja = new Framesaja();
        ftr.setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit);
        ftr.addToBackStack(null);
        ftr.replace(R.id.container,framesaja);
        ftr.commit();
    }

    void pindahframtext(){
        FragmentTransaction ftr = getSupportFragmentManager().beginTransaction();
        frametext = new Frametext();
        ftr.setCustomAnimations(R.anim.enter, R.anim.exit);
        ftr.addToBackStack(null);
        ftr.replace(R.id.container,frametext);
        ftr.commit();
    }

    @Override
    public void onClick(View view) {
        if (view==vbtnframesaja){
            pindahframsaja();
        }

        if (view==vbtnframetext) {
            pindahframtext();
        }

    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Choose_frame.this, MainActivity.class);
        finish();
        startActivity(a);
    }

}
