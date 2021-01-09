package com.example.portfolioapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;


public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.ProjectViewHolder> {
        private final LinkedList<String> mProjectList_title;
        private final LinkedList<String> mProjectList_image;
        private final LinkedList<String> mProjectList_description;

        private LayoutInflater mInflater;

        public PortfolioAdapter(Context context, //dit is de constructor
                                 LinkedList<String> projectList_title, LinkedList<String> projectList_image, LinkedList<String> projectList_description) {
            mInflater = LayoutInflater.from(context);
            this.mProjectList_title = projectList_title;
            this.mProjectList_image = projectList_image;
            this.mProjectList_description = projectList_description;
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
            String title = mProjectList_title.get(position);
            String image = mProjectList_image.get(position);

            holder.titleView.setText(String.format("%s", title));
            Picasso.get().load("http://www.hammerheaddesign.be" + image).into(holder.imageView);
            //geen holders meer toevoegen als je niets in de recyclerview wil steken

            String description = mProjectList_description.get(position);

            holder.btn_toDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (v.getContext(), ProjectDetail.class);

                    intent.putExtra("title", title); //verwijst naar String title = mProjectList
                    intent.putExtra("image", image);
                    intent.putExtra("description", description);


                    v.getContext().startActivity(intent);
                }
            });

        }


        @Override
        public int getItemCount() {
            return mProjectList_title.size();
        }

        class ProjectViewHolder extends RecyclerView.ViewHolder {
            public final Button btn_toDetail;
            final PortfolioAdapter mAdapter;
            public final TextView titleView;
            public final ImageView imageView;
            public final TextView descriptionView;

            public ProjectViewHolder(@NonNull View itemView, @NonNull PortfolioAdapter adapter) {
                super(itemView);
                btn_toDetail = itemView.findViewById(R.id.btn_toDetail);
                titleView = itemView.findViewById(R.id.tv_title);
                imageView = itemView.findViewById(R.id.iv_image);
                descriptionView = itemView.findViewById(R.id.selected_description);
                mAdapter = adapter;
            }
        }


    }


