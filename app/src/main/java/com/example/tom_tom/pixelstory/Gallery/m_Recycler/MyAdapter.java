package com.example.tom_tom.pixelstory.Gallery.m_Recycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tom_tom.pixelstory.Gallery.ActivityGallery;
import com.example.tom_tom.pixelstory.Gallery.Detail;
import com.example.tom_tom.pixelstory.Gallery.Spacecraft;
import com.example.tom_tom.pixelstory.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<Spacecraft> spacecrafts;

    public MyAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c=c;
        this.spacecrafts=spacecrafts;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final Spacecraft s=spacecrafts.get(position);
        holder.img.setImageURI(s.getUri());
        holder.nameTaxt.setText(s.getName());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c, Detail.class);
                i.putExtra("uri",s.getUri());
                i.putExtra("name",s.getName());
                c.startActivity(i);


            }
        });
    }

    public int getItemCount(){
        return spacecrafts.size();
    }

}
