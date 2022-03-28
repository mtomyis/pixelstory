package com.example.tom_tom.pixelstory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.tom_tom.pixelstory.Gallery.ActivityGallery;

public class MainActivity extends AppCompatActivity {

    Button vbtn_collage,about,galery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //membuat folder
//        File nfile=new File(Environment.getExternalStorageDirectory()+"/pixelstory");
//        nfile.mkdir();


        galery=(Button)findViewById(R.id.galery);
        galery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ActivityGallery.class);
                startActivity(intent);
                finish();
            }
        });

        about =(Button)findViewById(R.id.about);
        about.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,About.class);
                finish();
                startActivity(intent);
            }
        });
        vbtn_collage = (Button)findViewById(R.id.btn_collage);

        vbtn_collage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Choose_frame.class);
                finish();
                startActivity(i);

            }
        });

    }
    @Override
    public void onBackPressed() {
        showAlertDialog();
      //  finish();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Exit ?")
                .setNegativeButton("No", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        dialogInterface.dismiss();
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
