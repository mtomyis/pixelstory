package com.example.tom_tom.pixelstory.FrameSaja;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tom_tom.pixelstory.Choose_frame;
import com.example.tom_tom.pixelstory.Gallery.ActivityGallery;
import com.example.tom_tom.pixelstory.MainActivity;
import com.example.tom_tom.pixelstory.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class Lay5 extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_CAMERA = 0012;
    public static final int REQUEST_CODE_GALLERY = 0013;

    public static final int REQUEST_CODE_CAMERA1 = 0014;
    public static final int REQUEST_CODE_GALLERY1 = 0015;

    public static final int REQUEST_CODE_CAMERA2 = 0016;
    public static final int REQUEST_CODE_GALLERY2 = 0017;

    private final int CAMERA_RESULT = 101;

    private String [] items = {"Camera","Gallery"};

    ImageButton vimga1, vimga2, vimga3;
    private View mView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lay5);

        mView1 = findViewById(R.id.view5);
        Button mButton = (Button) findViewById(R.id.save5);
        mButton.setOnClickListener(this);

        mView1.setDrawingCacheEnabled(true);
        mView1.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        mView1.layout(0, 0, mView1.getMeasuredWidth(), mView1.getMeasuredHeight());
        mView1.buildDrawingCache(true);


        Button btnkembali = (Button)findViewById(R.id.back5);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Lay5.this,Choose_frame.class);
                startActivity(intent);
            }
        });

        vimga1 = (ImageButton) findViewById(R.id.img5a);
        vimga1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Lay5.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    openImage();
                }
                else{
                    if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(getApplicationContext(), "Permission Needed.", Toast.LENGTH_LONG).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_RESULT);
                }

            }
        });

        vimga2 = (ImageButton) findViewById(R.id.img5b);
        vimga2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Lay5.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    openImage1();
                }
                else{
                    if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(getApplicationContext(), "Permission Needed.", Toast.LENGTH_LONG).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_RESULT);
                }
            }
        });

        vimga3 = (ImageButton) findViewById(R.id.img5c);
        vimga3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Lay5.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    openImage2();
                }
                else{
                    if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(getApplicationContext(), "Permission Needed.", Toast.LENGTH_LONG).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_RESULT);
                }
                openImage2();
            }
        });

    }

    private void openImage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){
                    EasyImage.openCamera(Lay5.this,REQUEST_CODE_CAMERA);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay5.this, REQUEST_CODE_GALLERY);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openImage1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){
                    EasyImage.openCamera(Lay5.this,REQUEST_CODE_CAMERA1);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay5.this, REQUEST_CODE_GALLERY1);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openImage2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){
                    EasyImage.openCamera(Lay5.this,REQUEST_CODE_CAMERA2);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay5.this, REQUEST_CODE_GALLERY2);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                switch (type){
                    case REQUEST_CODE_CAMERA:
                        Glide.with(Lay5.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga1);
                        break;
                    case REQUEST_CODE_GALLERY:
                        Glide.with(Lay5.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga1);
                        break;

                    case REQUEST_CODE_CAMERA1:
                        Glide.with(Lay5.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga2);
                        break;
                    case REQUEST_CODE_GALLERY1:
                        Glide.with(Lay5.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga2);
                        break;

                    case REQUEST_CODE_CAMERA2:
                        Glide.with(Lay5.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga3);
                        break;
                    case REQUEST_CODE_GALLERY2:
                        Glide.with(Lay5.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga3);
                        break;
                }
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.save5) {
            Bitmap b = Bitmap.createBitmap(mView1.getDrawingCache());
            mView1.setDrawingCacheEnabled(false);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

            Calendar c = Calendar.getInstance();

            java.text.SimpleDateFormat currentDate = new java.text.SimpleDateFormat("HH_mm_ss");
            final String saveCurrentDate = currentDate.format(c.getTime());

            String root = Environment.getExternalStorageDirectory().toString();
            File folder = new File(root+"/Pictures/pixelstory");
            folder.mkdir();

            File my_file = new File(folder, saveCurrentDate+".JPEG");

            try {
                my_file.createNewFile();
                FileOutputStream fo = new FileOutputStream(my_file);
                fo.write(bytes.toByteArray());
                fo.flush();
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
         //   finish();
        }
        Intent i = new Intent(this, ActivityGallery.class);
        startActivity(i);
        finish();
        Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent h = new Intent(Lay5.this, Choose_frame.class);
        startActivity(h);
        finish();
    }
}
