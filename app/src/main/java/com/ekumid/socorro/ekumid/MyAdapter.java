package com.ekumid.socorro.ekumid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lucky on 29-03-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<ListItem> listItems;
    Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ListItem listItem=listItems.get(position);
        holder.Placename.setText(listItem.getPlaceName());
        holder.Address.setText(listItem.getAddress());
        holder.Ratting.setText(listItem.getPlaceName());
        holder.Distance.setText(listItem.getDistance());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView Placename,Ratting,Distance,Address;
       public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            Placename=(TextView)itemView.findViewById(R.id.tv_Name);
            Ratting=(TextView)itemView.findViewById(R.id.tv_ratting);
            Distance=(TextView)itemView.findViewById(R.id.tv_distance);
            Address=(TextView)itemView.findViewById(R.id.tv_address);
            imageView=(ImageView)itemView.findViewById(R.id.call);

        }
    }
}
