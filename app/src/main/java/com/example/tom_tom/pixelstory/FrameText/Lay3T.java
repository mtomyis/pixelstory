package com.example.tom_tom.pixelstory.FrameText;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
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


public class Lay3T extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_CAMERA = 0012;
    public static final int REQUEST_CODE_GALLERY = 0013;

    public static final int REQUEST_CODE_CAMERA1 = 0014;
    public static final int REQUEST_CODE_GALLERY1 = 0015;
    static final int REQUEST_PERMISSION_KEY = 1;

    TextView et_textjudul1, et_textcerita1;
    AlertDialog dialog, dialog2;
    EditText editText, editText2;
    Typeface et_fontmontserrat;

    private String [] items = {"Camera","Gallery"};

    //ini image edit frame
    ImageButton vimg1a, vimg2a;

    //ini button toolbar
    private Button mButton, btnkembali;

    private final int CAMERA_RESULT = 101;

    //ini view layout
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lay3t);

        et_textjudul1 = (TextView) findViewById(R.id.textjudul3);
        et_textcerita1 = (TextView) findViewById(R.id.textcerita3);
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


        btnkembali = (Button) findViewById(R.id.back3t);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindahkecollage();
            }
        });

        //awal fungsi save
        mView = findViewById(R.id.view3t);
        mButton = (Button) findViewById(R.id.save3t);
        mButton.setOnClickListener(this);

        mView.setDrawingCacheEnabled(true);
        mView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        mView.layout(0, 0, mView.getMeasuredWidth(), mView.getMeasuredHeight());
        mView.buildDrawingCache(true);
        // selesai


        vimg1a = (ImageButton) findViewById(R.id.img3at);
        vimg1a.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Lay3T.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    openImage();
                } else {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                        Toast.makeText(getApplicationContext(), "Permission Needed.", Toast.LENGTH_LONG).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_RESULT);
                }
            }
        });

        vimg2a = (ImageButton) findViewById(R.id.img3bt);
        vimg2a.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Lay3T.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    openImage1();
                } else {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                        Toast.makeText(getApplicationContext(), "Permission Needed.", Toast.LENGTH_LONG).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_RESULT);
                }
                openImage1();
            }
        });

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

    private void openImage() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){
                    EasyImage.openCamera(Lay3T.this,REQUEST_CODE_CAMERA);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay3T.this, REQUEST_CODE_GALLERY);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openImage1() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){
                    EasyImage.openCamera(Lay3T.this,REQUEST_CODE_CAMERA1);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(Lay3T.this, REQUEST_CODE_GALLERY1);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                switch (type){
                    case REQUEST_CODE_CAMERA:
                        Glide.with(Lay3T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimg1a);
                        break;
                    case REQUEST_CODE_GALLERY:
                        Glide.with(Lay3T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimg1a);
                        break;
                    case REQUEST_CODE_CAMERA1:
                        Glide.with(Lay3T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimg2a);
                        break;
                    case REQUEST_CODE_GALLERY1:
                        Glide.with(Lay3T.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(vimg2a);
                        break;
                }
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.save3t) {
            Bitmap b = Bitmap.createBitmap(mView.getDrawingCache());
            mView.setDrawingCacheEnabled(false);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

            Calendar c = Calendar.getInstance();

            java.text.SimpleDateFormat currentDate = new java.text.SimpleDateFormat("HH_mm_ss");
            final String saveCurrentDate = currentDate.format(c.getTime());

            File folder = new File ("sdcard/Pictures/pixelstory");
            if (!folder.exists()){
                folder.mkdir();
            }

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
        finish();
        Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
    }
}
