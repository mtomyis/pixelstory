package com.example.tom_tom.pixelstory.FrameText;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tom_tom.pixelstory.Choose_frame;
import com.example.tom_tom.pixelstory.FrameSaja.Lay9;
import com.example.tom_tom.pixelstory.Gallery.ActivityGallery;
import com.example.tom_tom.pixelstory.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class Lay9T extends AppCompatActivity implements View.OnClickListener {
    Button btnkembali;

    TextView et_textjudul1, et_textcerita1;
    AlertDialog dialog, dialog2;
    EditText editText, editText2;
    Typeface et_fontmontserrat;

    public static final int REQUEST_CODE_CAMERA = 0000;
    public static final int REQUEST_CODE_GALLERY = 0001;

    public static final int REQUEST_CODE_CAMERA1 = 0002;
    public static final int REQUEST_CODE_GALLERY1 = 0003;

    public static final int REQUEST_CODE_CAMERA2 = 0004;
    public static final int REQUEST_CODE_GALLERY2 = 0005;

    public static final int REQUEST_CODE_CAMERA3 = 0006;
    public static final int REQUEST_CODE_GALLERY3 = 0007;

    public static final int REQUEST_CODE_CAMERA4 = 0010;
    public static final int REQUEST_CODE_GALLERY4 = 0011;

    private final int CAMERA_RESULT = 101;

    private String [] items = {"Camera","Gallery"};

    ImageButton vimga1, vimga2, vimga3, vimga4, vimga5;
    private View mView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lay9t);

        et_textjudul1 = (TextView) findViewById(R.id.textjudul9);
        et_textcerita1 = (TextView) findViewById(R.id.textcerita9);
        et_fontmontserrat = Typeface.createFromAsset(this.getAssets(), "fonts/Montserrat-Regular.ttf");

        et_textjudul1.setTypeface(et_fontmontserrat);
        et_textcerita1.setTypeface(et_fontmontserrat);

        //awal fungsi alerdialog box ubah text
        dialog = new AlertDialog.Builder(this).create();
        dialog2 = new AlertDialog.Builder(this).create();

        editText = new EditText(this);
        editText2 = new EditText(this);

        dialog.setTitle("Edit Title");
        dialog.setView(editText);

        dialog2.setTitle("Edit the text");
        dialog2.setView(editText2);

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Save Title", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                et_textjudul1.setText(editText.getText());
            }
        });

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#00ff00"));
            }
        });

        et_textjudul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                editText.setText(et_textjudul1.getText());
                dialog.show();
            }
        });

        dialog2.setButton(DialogInterface.BUTTON_POSITIVE, "Save Text", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                et_textcerita1.setText(editText2.getText());
            }
        });

        dialog2.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                dialog2.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#00ff00"));
            }
        });

        et_textcerita1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                editText2.setText(et_textcerita1.getText());
                dialog2.show();
            }
        });
        //akhir fungsi alerdialog box ubah text

        btnkembali = (Button)findViewById(R.id.back9t);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindahkecollage();
            }
        });

        mView1 = findViewById(R.id.view9t);
        Button mButton = (Button) findViewById(R.id.save9t);
        mButton.setOnClickListener(this);

        mView1.setDrawingCacheEnabled(true);
        mView1.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        mView1.layout(0, 0, mView1.getMeasuredWidth(), mView1.getMeasuredHeight());
        mView1.buildDrawingCache(true);


        Button btnkembali = (Button)findViewById(R.id.back9t);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Lay9T.this,Choose_frame.class);
                startActivity(intent);
            }
        });

        vimga1 = (ImageButton) findViewById(R.id.img9at);
        vimga1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Lay9T.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
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

        vimga2 = (ImageButton) findViewById(R.id.img9bt);
        vimga2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Lay9T.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
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

        vimga3 = (ImageButton) findViewById(R.id.img9ct);
        vimga3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Lay9T.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    openImage2();
                }
                else{
                    if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(getApplicationContext(), "Permission Needed.", Toast.LENGTH_LONG).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_RESULT);
                }
            }
        });

        vimga4 = (ImageButton) findViewById(R.id.img9dt);
        vimga4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Lay9T.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    openImage3();
                }
                else{
                    if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(getApplicationContext(), "Permission Needed.", Toast.LENGTH_LONG).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_RESULT);
                }
            }
        });

        vimga5 = (ImageButton) findViewById(R.id.img9et);
        vimga5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Lay9T.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    openImage4();
                }
                else{
                    if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(getApplicationContext(), "Permission Needed.", Toast.LENGTH_LONG).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_RESULT);
                }
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
                    EasyImage.openCamera(Lay9T.this,REQUEST_CODE_CAMERA);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay9T.this, REQUEST_CODE_GALLERY);
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
                    EasyImage.openCamera(Lay9T.this,REQUEST_CODE_CAMERA1);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay9T.this, REQUEST_CODE_GALLERY1);
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
                    EasyImage.openCamera(Lay9T.this,REQUEST_CODE_CAMERA2);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay9T.this, REQUEST_CODE_GALLERY2);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openImage3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){
                    EasyImage.openCamera(Lay9T.this,REQUEST_CODE_CAMERA3);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay9T.this, REQUEST_CODE_GALLERY3);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openImage4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){
                    EasyImage.openCamera(Lay9T.this,REQUEST_CODE_CAMERA4);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay9T.this, REQUEST_CODE_GALLERY4);
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
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga1);
                        break;
                    case REQUEST_CODE_GALLERY:
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga1);
                        break;

                    case REQUEST_CODE_CAMERA1:
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga2);
                        break;
                    case REQUEST_CODE_GALLERY1:
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga2);
                        break;

                    case REQUEST_CODE_CAMERA2:
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga3);
                        break;
                    case REQUEST_CODE_GALLERY2:
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga3);
                        break;
                    case REQUEST_CODE_CAMERA3:
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga4);
                        break;
                    case REQUEST_CODE_GALLERY3:
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga4);
                        break;
                    case REQUEST_CODE_CAMERA4:
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga5);
                        break;
                    case REQUEST_CODE_GALLERY4:
                        Glide.with(Lay9T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimga5);
                        break;

                }
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.save9t) {
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
            finish();
        }
        Intent i = new Intent(this, ActivityGallery.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
    }

    private void pindahkecollage() {
        Intent i = new Intent(this, Choose_frame.class);
        finish();
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Choose_frame.class);
        finish();
        startActivity(i);
    }
}