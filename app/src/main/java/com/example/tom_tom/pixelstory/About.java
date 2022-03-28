package com.example.tom_tom.pixelstory;

/**
 * Created by TOM-TOM on 18/07/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class About extends AppCompatActivity {
    Number number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void bukaTelepon (View view){
        Intent bukaTelepon = TeleponIntent(About.this);
        finish();
        startActivity(bukaTelepon);
    }

    public void bukaEmail (View view){
        Intent bukaEmail = EmailIntent(About.this);
        finish();
        startActivity(bukaEmail);
    }

    public void bukaIg (View view){
        Intent bukaIg = InstagramIntent(About.this);
        finish();
        startActivity(bukaIg);
    }
    public void bukaFb (View view){
        Intent bukaFb = FacebookIntent(About.this);
        finish();
        startActivity(bukaFb);
    }
    public void bukaInternet (View view){
        Intent bukaInternet = InternetIntent(About.this);
        finish();
        startActivity(bukaInternet);
    }



    public static Intent TeleponIntent(Context context) {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+62 82299996281"));
        try {
            context.startActivity(i);
            return i;
        } catch (Exception e) {
            // this can happen if the device can't make phone calls
            // for example, a tablet
            return i;
        }
    }
    public static Intent EmailIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.google.android.gm", 0)  ; //Checks if Instagram is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://mail.google.com/")); //Trys to make intent with Instagram's URI
        }
        catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://mail.google.com/")); //catches and opens a url to the desired page
        }
    }

    public static Intent InstagramIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.instagram.android", 0); //Checks if Instagram is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/rootpixel/")); //Trys to make intent with Instagram's URI
        }
        catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/rootpixel/")); //catches and opens a url to the desired page
        }
    }

    public static Intent FacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0)  ; //Checks if Instagram is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/search/top/?q=rootpixel%20id")); //Trys to make intent with Instagram's URI
        }
        catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/search/top/?q=rootpixel%20id")); //catches and opens a url to the desired page
        }
    }

    public static Intent InternetIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.android.chrome", 0)  ; //Checks if Instagram is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://rootpixel.co.id/levidio/vol5/")); //Trys to make intent with Instagram's URI
        }
        catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://rootpixel.co.id/levidio/vol5/")); //catches and opens a url to the desired page
        }
    }
    @Override
    public void onBackPressed() {
        Intent a = new Intent(About.this, MainActivity.class);
        finish();
        startActivity(a);
    }

}

