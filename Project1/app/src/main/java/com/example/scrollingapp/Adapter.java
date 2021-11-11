package com.example.scrollingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<ScrollMainClass> scrollData;

    public Adapter(Context mContext, List<ScrollMainClass> scrollData) {
        this.mContext = mContext;
        this.scrollData = scrollData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.scoll_view,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.name.setText(scrollData.get(position).getUser().getName());
            holder.likes.setText(scrollData.get(position).getLikes());

        Glide.with(mContext)
                .load(scrollData.get(position).getUser().getProfImg().getMedium())
                .into(holder.profimg);
    }

    @Override
    public int getItemCount() {
        return scrollData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView likes;
        ImageView profimg;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Name);
            likes=itemView.findViewById(R.id.likes);
            profimg=itemView.findViewById(R.id.imageView);

        }
    }
}
