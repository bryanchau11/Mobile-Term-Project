package com.example.bordeauxien_restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button button_about, button_website, button_call, button_inquire, button_contact;
    ViewFlipper v_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int image[] = {R.drawable.window1, R.drawable.window2,R.drawable.window3,R.drawable.window4,R.drawable.window5,R.drawable.window6,R.drawable.window7};
        v_flipper = findViewById(R.id.v_flipper);

        for (int i=0; i<image.length; i++) {
            flipperImages(image[i]);

        }
        button_about = (Button) findViewById(R.id.about_button);
        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_about();
            }
        });
        button_website = (Button) findViewById(R.id.website_button);
        button_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              openActivity_login();
            }
        });
        button_call = (Button) findViewById(R.id.call_button);
        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_call();
            }
        });
        button_inquire = (Button) findViewById(R.id.inquire_button);
        button_inquire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_inquire();
            }
        });
        button_contact = (Button) findViewById(R.id.contact_button);
        button_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_contact();
            }
        });

    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(2000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void openActivity_about(){
        Intent intent = new Intent(this,  about.class );
        startActivity(intent);
    }
    public void openActivity_login(){
        Intent intent = new Intent(this,  Login.class );
        startActivity(intent);
    }
    public void openActivity_call(){
        Intent intent = new Intent(this,  call.class );
        startActivity(intent);
    }
    public void openActivity_inquire(){
        Intent intent = new Intent(this,  inquire.class );
        startActivity(intent);
    }
    public void openActivity_contact(){
        Intent intent = new Intent(this,  contact.class );
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu , menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.notification:

                return true;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Register.class));
                finish();
                break;
            case R.id.rate:
                startActivity(new Intent(getApplicationContext(), feedback.class));
                break;
            case R.id.share:
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Bordeauxien Restaurant";
                String shareSub = "Share Us";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent,"Share Using"));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}