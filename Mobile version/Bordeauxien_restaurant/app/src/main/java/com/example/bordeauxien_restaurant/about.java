package com.example.bordeauxien_restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.content.Intent.ACTION_DIAL;

public class about extends AppCompatActivity {

    ImageButton callButtonB, callButtonS, callButtonP, callButtonM;
    ImageButton websB, websS, websP, websM;
    TextView textview, textB, textS, textP, textM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Textfields to edit.
        textview = (TextView) findViewById(R.id.aboutText);
        //type text in between ""
        String para = "Since planting our first vines in 1962, the Plantier family name has become synonymous with the highest quality French varietal wines from the Bordeaux region. For the team at Plantier Family Winery, every harvest is the realization of the French dream\n"
                +  "Today, we believe in the importance of family more than ever – the one you’re born into and the one you choose. There is always a seat at our table and all are welcome to share in our daily celebration of family, Plantier, and the bounty "
                +  "of our home in Bordeaux.\n"
                + "We aim to support our local area. We also provide services that could help those who are always in rush due to their busy work from our city. "
                + "Bordeauxien also do our best to source locally made foods and accessories to sell at our tasting rooms as well!\n"
                + "\n"
                + "See you soon!";
        textview.setText(para);
        textview.setMovementMethod(new ScrollingMovementMethod());

        textB = (TextView) findViewById(R.id.textBryan);
        //type text in between ""
        String paraB = "about Bryan \n  I'm a team leader and my task for this project was doing most of the stuff (80% of the project)";
        textB.setText(paraB);
        textB.setMovementMethod(new ScrollingMovementMethod());

        textS = (TextView) findViewById(R.id.textSunwoo);
        //type text in between ""
        String paraS = "about Sunwoo \n  I did about page, contact page, user stories and many things.";
        textS.setText(paraS);
        textS.setMovementMethod(new ScrollingMovementMethod());

        textP = (TextView) findViewById(R.id.textPriya);
        //type text in between ""
        String paraP = "about Priya \n  Flutter and Call page and application flow chart";
        textP.setText(paraP);
        textP.setMovementMethod(new ScrollingMovementMethod());

        textM = (TextView) findViewById(R.id.textMaanasa);
        //type text in between ""
        String paraM = "about Maanasa \n  No clue";
        textM.setText(paraM);
        textM.setMovementMethod(new ScrollingMovementMethod());

        callButtonB = findViewById(R.id.phoneB);
        callButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1234567890"));
                startActivity(intent);
            }
        });

        websB = findViewById(R.id.webB);
        websB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/bryanchau11"));
                startActivity(intent);
            }
        });

        callButtonS = findViewById(R.id.phoneS);
        callButtonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0987654321"));
                startActivity(intent);
            }
        });

        websS = findViewById(R.id.webS);
        websS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/sunwoo14"));
                startActivity(intent);
            }
        });

        callButtonP = findViewById(R.id.phoneP);
        callButtonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:6789012345"));
                startActivity(intent);
            }
        });

        websP = findViewById(R.id.webP);
        websP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/hvuppu"));
                startActivity(intent);
            }
        });

        callButtonM = findViewById(R.id.phoneM);
        callButtonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1234509876"));
                startActivity(intent);
            }
        });

        websM = findViewById(R.id.webM);
        websM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/lmaanasa16"));
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu , menu);
        return true;
    }
}