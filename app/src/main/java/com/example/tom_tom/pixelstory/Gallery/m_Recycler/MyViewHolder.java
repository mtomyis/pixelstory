package com.example.tom_tom.pixelstory.Gallery.m_Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom_tom.pixelstory.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nameTaxt;
    ImageView img;

    public MyViewHolder(View itemView){
        super(itemView);

        nameTaxt=(TextView) itemView.findViewById(R.id.nameTxt);
        img=(ImageView) itemView.findViewById(R.id.spacecraftImg);
    }
}
