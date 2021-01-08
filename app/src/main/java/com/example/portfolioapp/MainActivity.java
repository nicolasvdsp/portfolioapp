package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private static final String myURL = "http://hammerheaddesign.be/api";

    private final LinkedList<String> mProjectList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private PortfolioAdapter mAdapter;
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity main verwijst naar xml file
        mQueue = Volley.newRequestQueue(this);

        mRecyclerView = findViewById(R.id.rv_projects);
        mAdapter = new PortfolioAdapter(this, mProjectList); // List is empty at this point
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        JsonArrayRequest request = new JsonArrayRequest(myURL,

                response -> {
                    // Method executed when the response is successful
                    for (int i=0; i<response.length(); i++) {
                        try {
                            JSONObject projectjson = response.getJSONObject(i);
                            mProjectList.add(projectjson.getString("title")); //title is van de drupal api
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    // Let the adapter know that it has to redraw itself
                    mAdapter.notifyDataSetChanged();
                },
                error -> {
                    // Method executed when there is an error.
                    Log.e("FizzBuzz", error.getMessage());
                });

        // Set the request up for execution
        mQueue.add(request);
    }

}
