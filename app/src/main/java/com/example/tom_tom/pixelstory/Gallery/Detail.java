package com.example.tom_tom.pixelstory.Gallery;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tom_tom.pixelstory.FrameSaja.Lay1;
import com.example.tom_tom.pixelstory.MainActivity;
import com.example.tom_tom.pixelstory.R;
import com.robertsimoes.shareable.Shareable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import pl.aprilapps.easyphotopicker.EasyImage;

public class Detail extends AppCompatActivity implements View.OnClickListener {

    private Uri fille;
    ImageView imgfull;
    Button del,share;

    private String [] items = {"Yes","No"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        final ImageView imgfull=(ImageView)findViewById(R.id.myImagefull);

        imgfull.setOnClickListener(this);
        Intent call = getIntent();
        if (call !=null){
            fille=call.getData();
            if (fille !=null && imgfull !=null ){
                Glide.with(this)
                        .load(fille)
                        .into(imgfull);

                //share kirim image ke method share
                final ContentResolver cr = getContentResolver();
                final String[] p1 = new String[] {
                        MediaStore.Images.ImageColumns._ID, MediaStore.Images.ImageColumns.TITLE, MediaStore.Images.ImageColumns.DATE_TAKEN
                };
                Cursor c1 = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, p1, null, null, p1[1] + " DESC");
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"+ Environment.getExternalStorageDirectory()+ "/Picture/pixelstory/" + c1.getString(1)+".JPEG")));
            }
        }

        final Uri uri = (Uri) getIntent().getExtras().get("uri");
        Glide.with(Detail.this).load(uri).into(imgfull);

        //delete image from galery
       Button dell=findViewById(R.id.del);
        dell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               deletepora();
            }
        });

        //share
        Button sh=findViewById(R.id.share);
        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "image/*";
                String filename = getIntent().getExtras().getString("name");
                String mediaPath = Environment.getExternalStorageDirectory()+"/Pictures/pixelstory/"+filename;
                createInstagramIntent(type, mediaPath);
            }
        });
}

// ini share method baru
    private void createInstagramIntent(String type, String mediaPath){

        // Create the new Intent using the 'Send' action.
        Intent share = new Intent(Intent.ACTION_SEND);

        // Set the MIME type
        share.setType(type);

        // Create the URI from the media
        File media = new File(mediaPath);
        Uri uri = Uri.fromFile(media);

        // Add the URI to the Intent.
        share.putExtra(Intent.EXTRA_STREAM, uri);

        // Broadcast the Intent.
        startActivity(Intent.createChooser(share, "Share to"));
    }

//  awal method share sambil buat file baru
    public Uri getLocalBitmapUri(Bitmap imageView) {
        imgfull.buildDrawingCache();
        Bitmap bm = imgfull.getDrawingCache();

        OutputStream fOut = null;
        Uri outputFileUri = null;
        try {
            File root = new File(Environment.getExternalStorageDirectory()+"/Picture/pixelstory/");
            root.mkdirs();
            File imageFile = new File(root, "inifileshare.jpg");
            outputFileUri = Uri.fromFile(imageFile);
            fOut = new FileOutputStream(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bm.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            return outputFileUri;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //akhir method share

    //cek instagram
    private boolean verificaInstagram(){
        boolean installed = false;

        try {
            ApplicationInfo info = getPackageManager().getApplicationInfo("com.instagram.android", 0);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }


    private void deletepora() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Yes")){
                    final Uri uri = (Uri) getIntent().getExtras().get("uri");
                    File fdelete = new File(uri.getPath());
                    if (fdelete.exists()) {
                        if (fdelete.delete()) {
                            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(uri.getPath()))));
                            Toast.makeText(Detail.this, "File Deleted" +uri.getPath(), Toast.LENGTH_SHORT).show();
//                        System.out.println("file Deleted :" + uri.getPath());

                            finish();
                        } else {
                            //sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(uri.getPath()))));
                            Toast.makeText(Detail.this, "File Not Deleted" +uri.getPath(), Toast.LENGTH_SHORT).show();
//                        System.out.println("file not Deleted :" + uri.getPath());
                            finish();
                        }
                    }
                    keluar();
                }else if(items[i].equals("No")){
                    finish();
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
//        finish();
//        return;
    }

    private void keluar() {
        Intent i = new Intent(Detail.this, ActivityGallery.class);
        startActivity(i);
        finish();
    }
    private Intent createShareIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, fille);
        return shareIntent;
    }

    @Override
    public void onClick(View v) {

    }


//    @Override
//    public boolean onLongClick(View v) {
//        Intent shareIntent = createShareIntent();
//        startActivity(Intent.createChooser(shareIntent, "send to"));
//        return true;
//
//    }
//    @Override
//    public void onBackPressed() {
//        Intent a = new Intent(Detail.this, ActivityGallery.class);
//        startActivity(a);
//        finish();
//    }
}
