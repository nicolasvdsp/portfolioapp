package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProjectDetail extends AppCompatActivity {

    String selectedTitle;
    String selectedDescription;

    TextView mTitleTextView;
    TextView mDescriptionView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        Intent intent = getIntent();
        selectedTitle = intent.getStringExtra("title");
        selectedDescription = intent.getStringExtra("description");

        mTitleTextView = (TextView) findViewById(R.id.selected_title);
        mDescriptionView = (TextView) findViewById(R.id.selected_description);

        mTitleTextView.setText(selectedTitle);
        mDescriptionView.setText(selectedDescription);

    }

}