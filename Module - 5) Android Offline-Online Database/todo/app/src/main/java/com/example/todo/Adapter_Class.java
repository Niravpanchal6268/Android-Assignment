package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Class extends RecyclerView.Adapter<holder_view_class> {
    ArrayList<model> tlist;
    Context context;

    public Adapter_Class(ArrayList<model> tlist, Context context) {
        this.tlist = tlist;
        this.context = context;
    }

    @NonNull
    @Override
    public holder_view_class onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_card, parent, false);

        return new holder_view_class(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder_view_class holder, int position) {
        final model temp = tlist.get(position);
        holder.tsid.setText(String.valueOf(tlist.get(position).getId()));
        holder.title.setText(tlist.get(position).getTitle());
        holder.desc.setText(tlist.get(position).getDes());
        holder.date.setText(tlist.get(position).getDate());


    }

    @Override
    public int getItemCount() {
        return tlist.size();
    }


}
