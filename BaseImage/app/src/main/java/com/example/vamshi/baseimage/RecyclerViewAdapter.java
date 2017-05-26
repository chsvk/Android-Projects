package com.example.vamshi.baseimage;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vamshi on 5/22/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public List<LinkObject> listOfLinks;
    public Context context;

    public RecyclerViewAdapter(List<LinkObject> listOfLinks, Context context) {
        this.listOfLinks = listOfLinks;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LinkObject linky = listOfLinks.get(position);
        //Toast.makeText(context, linky.getImagelink(), Toast.LENGTH_SHORT).show();
        Glide.with(context).load(linky.getImagelink()).into(holder.myImageView);
 
    }

    @Override
    public int getItemCount() {
        return listOfLinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView myTextview;
        public ImageView myImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            myImageView = (ImageView) itemView.findViewById(R.id.myImage);
            myTextview = (TextView)itemView.findViewById(R.id.myText);
        }
    }
}
