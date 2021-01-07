package com.example.taboolahometest.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taboolahometest.R;
import com.example.taboolahometest.pojo.ItemModel;
import com.taboola.android.TaboolaWidget;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<ItemModel> itemsList = new ArrayList<>();

    private TaboolaWidget mMiddleTaboolaWidget;
    private Context mContext;
    private String emptyText = "";


    public ItemsAdapter(Context mContext){
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_taboola,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int position) {

        holder.name.setText(itemsList.get(position).getName());
        holder.description.setText(itemsList.get(position).getDescription());
        // get the image via Glide library


        Glide.with(mContext)
                .load(itemsList.get(position).getThumbnail())
                .into(holder.thumbnail);

        // to make cell 3 && 10 empty:

        if(position == 3 || position == 10){
            holder.name.setText("");
            holder.description.setText("");
            holder.thumbnail.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void setList(List<ItemModel> itemsList){
        this.itemsList = itemsList;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView name, description;
        ImageView thumbnail;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTextView);
            description = itemView.findViewById(R.id.descriptionTextView);
            thumbnail = itemView.findViewById(R.id.imageView);

        }
    }
}
