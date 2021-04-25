package com.example.bordeauxien_restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class inquire extends AppCompatActivity {
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    EditText mFullName, mEmail, mPhone, mText;
    Button mSubmit;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mSubmit = findViewById(R.id.button_submit);
        mFullName = findViewById(R.id.fullname_contact);
        mEmail = findViewById(R.id.email_contact);
        mText = findViewById(R.id.feedback_contact);
        mPhone = findViewById(R.id.phone_contact);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String text = mText.getText().toString().trim();
                String fullname = mFullName.getText().toString().trim();
                String phone = mPhone.getText().toString().trim();

                userID = fAuth.getCurrentUser().getUid();
                DocumentReference documentReference = fStore.collection("Inquire Detail").document(userID);
                java.util.Map<String, Object> contact = new HashMap<>();
                contact.put("1.Full Name", fullname);
                contact.put("2.Email", email);
                contact.put("3.Phone", phone);
                contact.put("4.Contact message", text);
                Toast.makeText(inquire.this, "Thank you! Your contact message has been saved!" , Toast.LENGTH_SHORT).show();
                documentReference.set(contact).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
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