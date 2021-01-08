package com.example.portfolioapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;


public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.ProjectViewHolder> {
        private final LinkedList<String> mProjectList;
        private LayoutInflater mInflater;

        public PortfolioAdapter(Context context,
                                 LinkedList<String> projectList) {
            mInflater = LayoutInflater.from(context);
            this.mProjectList = projectList;
        }


        @NonNull
        @Override
        public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mProjectView = mInflater.inflate(R.layout.projectview, //verwijst naar xml file
                    parent, false);

            TextView tv_title = mProjectView.findViewById(R.id.title);
            // We set the holder_tv TextView to the number of the holder. This allows us to count
            // how many holders Android has requested.

            return new ProjectViewHolder(mProjectView, this);
        }

        @Override
        public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
            String title = mProjectList.get(position);
            holder.titleView.setText(String.format("%s", title));

        }

        @Override
        public int getItemCount() {
            return mProjectList.size();
        }

        class ProjectViewHolder extends RecyclerView.ViewHolder {
            final PortfolioAdapter mAdapter;
            public final TextView titleView;

            public ProjectViewHolder(@NonNull View itemView, @NonNull PortfolioAdapter adapter) {
                super(itemView);
                titleView = itemView.findViewById(R.id.title);
                mAdapter = adapter;
            }
        }

    }


