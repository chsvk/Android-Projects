package com.example.vamshi.recyclerviewtest;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vamshi on 5/21/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public List<ModelForListItem> listItems;

    public Adapter(List<ModelForListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelForListItem item = listItems.get(position);

        holder.heading.setText(item.getHeading());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView heading;
        public TextView description;
        public ViewHolder(View itemView) {
            super(itemView);

            heading = (TextView)itemView.findViewById(R.id.heading);
            description = (TextView)itemView.findViewById(R.id.description);

        }
    }
}
