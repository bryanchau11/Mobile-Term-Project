package com.example.bordeauxien_restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class feedback extends AppCompatActivity {


    private RatingBar ratingBar;
    private TextView tvRateCount,tvRateMessage;

    private float ratedValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);// Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvRateMessage = findViewById(R.id.tvRateMessage);
        tvRateCount = findViewById(R.id.tvRateCount);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar_feedback);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override

            public void onRatingChanged(RatingBar ratingBar, float rating,

                                        boolean fromUser) {

                ratedValue = ratingBar.getRating();

                tvRateCount.setText("Your Rating : "

                        + ratedValue + "/5.");
                tvRateCount.setVisibility(View.VISIBLE);
                if(ratedValue<1){
                    Toast.makeText(feedback.this, "Thank you, your response has been saved", Toast.LENGTH_SHORT).show();

                    tvRateMessage.setText("ohh ho...");
                    tvRateMessage.setVisibility(View.VISIBLE);
                }else if(ratedValue<2){
                    Toast.makeText(feedback.this, "Thank you, your response has been saved", Toast.LENGTH_SHORT).show();
                    tvRateMessage.setText("Ok.");
                    tvRateMessage.setVisibility(View.VISIBLE);
                }else if(ratedValue<3){
                    Toast.makeText(feedback.this, "Thank you, your response has been saved", Toast.LENGTH_SHORT).show();
                    tvRateMessage.setText("Not bad.");
                    tvRateMessage.setVisibility(View.VISIBLE);
                }else if(ratedValue<4){
                    Toast.makeText(feedback.this, "Thank you, your response has been saved", Toast.LENGTH_SHORT).show();
                    tvRateMessage.setText("Nice");
                    tvRateMessage.setVisibility(View.VISIBLE);
                }else if(ratedValue<5){
                    Toast.makeText(feedback.this, "Thank you, your response has been saved", Toast.LENGTH_SHORT).show();
                    tvRateMessage.setText("Very Nice");
                    tvRateMessage.setVisibility(View.VISIBLE);
                }else if(ratedValue==5){
                    Toast.makeText(feedback.this, "Thank you, your response has been saved", Toast.LENGTH_SHORT).show();
                    tvRateMessage.setText("Thank you..!!!");
                    tvRateMessage.setVisibility(View.VISIBLE);
                }

            }

        });

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
            case R.id.search:
                return true;
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