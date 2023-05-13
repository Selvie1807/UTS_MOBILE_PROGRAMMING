package com.example.wisatalampung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.Viewholder> {

    private ArrayList<itemModel> dataItem;

    private final Context context;
    public static class Viewholder extends RecyclerView.ViewHolder {
        TextView textHead;
        TextView textSubhead;
        ImageView imageIcon;

        public Viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            textHead = itemView.findViewById(R.id.title);
            textSubhead = itemView.findViewById(R.id.sub_title);
            imageIcon = itemView.findViewById(R.id.image);
        }
    }

    AdapterRecyclerView(ArrayList<itemModel> context, Object dataItem) {
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.Viewholder holder, int position) {

        TextView texthead = holder.textHead;
        TextView textsubhead = holder.textSubhead;
        ImageView imageIcon = holder.imageIcon;

        texthead.setText(dataItem.get(position).getName());
        textsubhead.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    void setFilter(ArrayList<itemModel> filterModel) {
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
