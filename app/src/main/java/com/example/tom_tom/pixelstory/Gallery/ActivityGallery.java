package com.example.tom_tom.pixelstory.Gallery;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.tom_tom.pixelstory.Choose_frame;
import com.example.tom_tom.pixelstory.Gallery.m_Recycler.MyAdapter;
import com.example.tom_tom.pixelstory.MainActivity;
import com.example.tom_tom.pixelstory.R;

import java.io.File;
import java.util.ArrayList;


public class ActivityGallery extends AppCompatActivity {
    private final static int READ_EXTERNAL_STORAGE_PERMMISSION_RESULT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

//        rv.setLayoutManager(new LinearLayoutManager(this));

        Button vbtnback = (Button) findViewById(R.id.btnkembalii);
        vbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityGallery.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finishAffinity();
                startActivity(intent);

            }
        });

        checkReadExternalStoragePermission();
    }

    //cek permisi
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case READ_EXTERNAL_STORAGE_PERMMISSION_RESULT:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    laksanakan();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void laksanakan() {
        final RecyclerView rv=(RecyclerView)findViewById(R.id.rv_gallery);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(mLayoutManager);

        rv.setAdapter(new MyAdapter(ActivityGallery.this,getData()));

    }

    private void checkReadExternalStoragePermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_GRANTED) {
                laksanakan();
            } else {
                if(shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "App needs to view thumbnails", Toast.LENGTH_SHORT).show();
                }
                requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        READ_EXTERNAL_STORAGE_PERMMISSION_RESULT);
            }
        } else {
            // Start cursor loader
            laksanakan();
        }
    }
    //cek permisi


    private ArrayList<Spacecraft> getData() {

        ArrayList<Spacecraft> spacecrafts=new ArrayList<>();

        //target folder
        File folder = new File(Environment.getExternalStorageDirectory()+"/Pictures/pixelstory");
        Spacecraft s;

        if(folder.exists())
        {
            File[] files=folder.listFiles();

            for (int i=0; i<files.length; i++)
            {
                File file=files[i];

                s=new Spacecraft();
                s.setName(file.getName());
                s.setUri(Uri.fromFile(file));

                spacecrafts.add(s);
            }
        }
        return spacecrafts;
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ActivityGallery.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finishAffinity();
        startActivity(intent);

//        Intent a = new Intent(ActivityGallery.this, MainActivity.class);
//        startActivity(a);
//        finish();
    }
}
