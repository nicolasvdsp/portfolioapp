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
        private final LinkedList<String> mProjectList_url;
        private final LinkedList<String> mProjectList_course;
        private final LinkedList<String> mProjectList_skill;
        private final LinkedList<String> mProjectList_category;

        private LayoutInflater mInflater;

        public PortfolioAdapter(Context context, //dit is de constructor
                                 LinkedList<String> projectList_title,
                                 LinkedList<String> projectList_image,
                                 LinkedList<String> projectList_description,
                                 LinkedList<String> projectList_url,
                                 LinkedList<String> projectList_course,
                                 LinkedList<String> projectList_skill,
                                 LinkedList<String> projectList_category)
        {
            mInflater = LayoutInflater.from(context);
            this.mProjectList_title = projectList_title;
            this.mProjectList_image = projectList_image;
            this.mProjectList_description = projectList_description;
            this.mProjectList_url = projectList_url;
            this.mProjectList_course = projectList_course;
            this.mProjectList_skill = projectList_skill;
            this.mProjectList_category = projectList_category;
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
            String description = mProjectList_description.get(position);
            String url = mProjectList_url.get(position);
            String course = mProjectList_course.get(position);
            String skill = mProjectList_skill.get(position);
            String category = mProjectList_category.get(position);


            //Enkel als het in de recyclerview moet komen
            holder.titleView.setText(String.format("%s", title));
            Picasso.get().load("http://www.hammerheaddesign.be" + image).into(holder.imageView);
            //geen holders meer toevoegen als je niets in de recyclerview wil steken


            holder.btn_toDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (v.getContext(), ProjectDetail.class);

                    intent.putExtra("title", title); //verwijst naar String title = mProjectList
                    intent.putExtra("image", image);
                    intent.putExtra("description", description);
                    intent.putExtra("project_url", url);
                    intent.putExtra("course", course);
                    intent.putExtra("skill", skill);
                    intent.putExtra("category", category);


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
            public final TextView urlView;
            public final TextView courseView;
            public final TextView skillView;
            public final TextView categoryView;

            public ProjectViewHolder(@NonNull View itemView, @NonNull PortfolioAdapter adapter) {
                super(itemView);
                btn_toDetail = itemView.findViewById(R.id.btn_toDetail);
                titleView = itemView.findViewById(R.id.tv_title);
                imageView = itemView.findViewById(R.id.iv_image);
                descriptionView = itemView.findViewById(R.id.selected_description);
                urlView = itemView.findViewById(R.id.selected_url);
                courseView = itemView.findViewById(R.id.selected_course);
                skillView = itemView.findViewById(R.id.selected_skill);
                categoryView = itemView.findViewById(R.id.selected_category);


                mAdapter = adapter;
            }
        }


    }


