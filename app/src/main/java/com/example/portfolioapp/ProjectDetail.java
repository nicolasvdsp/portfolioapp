package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProjectDetail extends AppCompatActivity {

    String selectedTitle;
    String selectedImage;
    String selectedDescription;

    TextView mTitleTextView;
    ImageView mImageView;
    TextView mDescriptionView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        Intent intent = getIntent();
        selectedTitle = intent.getStringExtra("title");
        selectedImage = intent.getStringExtra("image");
        selectedDescription = intent.getStringExtra("description");

        mTitleTextView = (TextView) findViewById(R.id.selected_title);
        mImageView = findViewById(R.id.selected_image);
        mDescriptionView = (TextView) findViewById(R.id.selected_description);

        mTitleTextView.setText(selectedTitle);
        Picasso.get().load("http://www.hammerheaddesign.be" + selectedImage).into(mImageView);
        mDescriptionView.setText(selectedDescription);

        //Picasso.get().load("http://www.hammerheaddesign.be" + image).into(holder.imageView);
    }

}