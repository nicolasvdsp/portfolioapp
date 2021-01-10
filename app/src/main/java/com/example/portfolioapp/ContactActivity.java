package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static java.lang.System.load;

public class ContactActivity extends AppCompatActivity {

    ImageView profilePictureView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        profilePictureView = findViewById(R.id.profilepicture);

        Picasso.get().load("http://hammerheaddesign.be/sites/default/files/inline-images/profilepicture.jpg").into(profilePictureView);

    }

    public void contactToProjects(View v) {
        Intent intent = new  Intent(this, MainActivity.class);
        startActivity(intent);
    }
}