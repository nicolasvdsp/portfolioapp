package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private static final String myURL = "http://hammerheaddesign.be/api";

    private final LinkedList<String> mProjectList_title = new LinkedList<>();
    private final LinkedList<String> mProjectList_image = new LinkedList<>();
    private final LinkedList<String> mProjectList_description = new LinkedList<>();
    private final LinkedList<String> mProjectList_url = new LinkedList<>();
    private final LinkedList<String> mProjectList_course = new LinkedList<>();
    private final LinkedList<String> mProjectList_skill = new LinkedList<>();
    private final LinkedList<String> mProjectList_category = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private PortfolioAdapter mAdapter;
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity main verwijst naar xml file
        mQueue = Volley.newRequestQueue(this);

        mRecyclerView = findViewById(R.id.rv_projects);
        mAdapter = new PortfolioAdapter(this, mProjectList_title, mProjectList_image, mProjectList_description, mProjectList_url, mProjectList_course, mProjectList_skill, mProjectList_category); // List is empty at this point
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        JsonArrayRequest request = new JsonArrayRequest(myURL,

                response -> {
                    // Method executed when the response is successful
                    for (int i=0; i<response.length(); i++) {
                        try {
                            JSONObject projectjson = response.getJSONObject(i);
                            mProjectList_title.add(projectjson.getString("title")); //title is van de drupal api
                            mProjectList_image.add(projectjson.getString("image"));
                            mProjectList_description.add(projectjson.getString("description"));
                            mProjectList_url.add(projectjson.getString("project_url"));
                            mProjectList_course.add(projectjson.getString("course"));
                            mProjectList_skill.add(projectjson.getString("skill"));
                            mProjectList_category.add(projectjson.getString("category"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    // Let the adapter know that it has to redraw itself
                    mAdapter.notifyDataSetChanged();
                },
                error -> {
                    // Method executed when there is an error.
                    Log.e("The app is not responding", error.getMessage());
                });

        // Set the request up for execution
        mQueue.add(request);






    }

}
