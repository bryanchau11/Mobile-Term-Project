package com.example.bordeauxien_restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    private Button button_about, button_website, button_call, button_inquire, button_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
              openActivity_website();
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



    public void openActivity_about(){
        Intent intent = new Intent(this,  about.class );
        startActivity(intent);
    }
    public void openActivity_website(){
        Intent intent = new Intent(this,  website.class );
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
}