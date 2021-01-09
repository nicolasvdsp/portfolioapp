package com.example.portfolioapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;


public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.ProjectViewHolder> {
        private final LinkedList<String> mProjectList;
        private final LinkedList<String> mProjectListSecond;
        private LayoutInflater mInflater;

        public PortfolioAdapter(Context context,
                                 LinkedList<String> projectList, LinkedList<String> projectListSecond) {
            mInflater = LayoutInflater.from(context);
            this.mProjectList = projectList;
            this.mProjectListSecond = projectListSecond;
        }


        @NonNull
        @Override
        public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mProjectView = mInflater.inflate(R.layout.projectview, //verwijst naar xml file
                    parent, false);

            return new ProjectViewHolder(mProjectView, this);
        }


        @Override
        public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
            String title = mProjectList.get(position);
            String image = mProjectListSecond.get(position);
            holder.titleView.setText(String.format("%s", title));
            Picasso.get().load("http://www.hammerheaddesign.be" + image).into(holder.imageView);
            //holder.imageView.setImageURI("http://www.hammerheaddesign.be" + image);

            //holder.imageView.setImageURI(Uri.parse(image));

        }


        @Override
        public int getItemCount() {
            return mProjectList.size();
        }

        class ProjectViewHolder extends RecyclerView.ViewHolder {
            final PortfolioAdapter mAdapter;
            public final TextView titleView;
            public final ImageView imageView;

            public ProjectViewHolder(@NonNull View itemView, @NonNull PortfolioAdapter adapter) {
                super(itemView);
                titleView = itemView.findViewById(R.id.tv_title);
                imageView = itemView.findViewById(R.id.iv_image);
                mAdapter = adapter;
            }
        }

    }


