package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProjectDetail extends AppCompatActivity {

    String selectedTitle;
    String selectedImage;
    String selectedDescription;
    String selectedUrl;
    String selectedCourse;
    String selectedSkill;
    String selectedCategory;

    TextView mTitleTextView;
    ImageView mImageView;
    TextView mDescriptionView;
    TextView mUrlView;
    TextView mCourseView;
    TextView mSkillView;
    TextView mCategoryView;

    Button btn_share;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        Intent intent = getIntent();
        selectedTitle = intent.getStringExtra("title");
        selectedImage = intent.getStringExtra("image");
        selectedDescription = intent.getStringExtra("description");
        selectedUrl = intent.getStringExtra("project_url");
        selectedCourse = intent.getStringExtra("course");
        selectedSkill = intent.getStringExtra("skill");
        selectedCategory = intent.getStringExtra("category");

        mTitleTextView = (TextView) findViewById(R.id.selected_title);
        mImageView = findViewById(R.id.selected_image);
        mDescriptionView = (TextView) findViewById(R.id.selected_description);
        mUrlView = (TextView) findViewById(R.id.selected_url);
        mCourseView = (TextView) findViewById(R.id.selected_course);
        mSkillView = (TextView) findViewById(R.id.selected_skill);
        mCategoryView = (TextView) findViewById(R.id.selected_category);

        mTitleTextView.setText(selectedTitle);
        Picasso.get().load("http://www.hammerheaddesign.be" + selectedImage).into(mImageView);
        mDescriptionView.setText(selectedDescription);
        mUrlView.setText("Go to this project: \n" + selectedUrl);
        mCourseView.setText("Course: " + selectedCourse);
        mSkillView.setText("Skills: " + selectedSkill);
        mCategoryView.setText("Category: " + selectedCategory);


        btn_share = findViewById(R.id.btn_share);

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Check out " + selectedTitle + "!\n" + "See this project on " + selectedUrl);
                intent.setType("text/plain");

                if(intent.resolveActivity(v.getContext().getPackageManager()) != null) { //If statement gaat na of er wel andere apps zijn op het toestel die luisteren naar een impliciete intent.
                    startActivity(intent);
                }
            }
        });

    }

}