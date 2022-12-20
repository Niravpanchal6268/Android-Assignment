package com.example.dailyexpensetracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<Myviewholder> {
    ArrayList<model> elist;

    Context context;

    public MyAdapter(ArrayList<model> elist, Context context) {
        this.elist = elist;
        this.context = context;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_card, parent, false);

        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText(elist.get(position).getTitle());
        holder.des.setText(elist.get(position).getDescription());
        holder.date.setText(elist.get(position).getDate());
        holder.Id.setText(String.valueOf(elist.get(position).getId()));
        holder.expence.setText(String.valueOf(elist.get(position).getExpence()));


//        holder.singlecard.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//
////                Toast.makeText(view.getContext(), "alerDialog", Toast.LENGTH_SHORT).show();
//                Database_class db = new Database_class(view.getContext());
//                String t = holder.title.getText().toString();
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                builder.setIcon(R.drawable.ic_baseline_delete_24);
//                builder.setTitle("Delete");
//                builder.setMessage("Delete this expense");
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        db.DeleteSingleitem(t);
////                        notifyItemRangeChanged(position,elist.size());
//                      notifyDataSetChanged();
//
//                    }
//                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//
//                builder.show();
//
//                return true;
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return elist.size();
    }

//    @Override
//    public Filter getFilter() {
//        return filter;
//    }
//
//    Filter filter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence keyword) {
//
//            ArrayList<model> fliterdata = new ArrayList<>();
//            if (keyword.toString().isEmpty()) {
//                fliterdata.addAll(backup);
//            } else {
//                for (model obj : backup) {
//                    if (obj.getTitle().toString().toLowerCase().contains(keyword.toString().toLowerCase())) {
//                        fliterdata.add(obj);
//                    }
//                }
//
//            }
//            FilterResults results = new FilterResults();
//            results.values = fliterdata;
//            return results;
//
//        }

    //        @Override
//        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//
//            elist.clear();
//            elist.addAll((ArrayList<model>) filterResults.values);
//            notifyDataSetChanged();
//        }
//    };
    public void delete(int a) {
        model m = elist.get(a);
        System.out.println("id:" + m);
        int id = m.getId();
        MainActivity mainActivity = new MainActivity();
        Database_class db = new Database_class(context);
        boolean d = db.DeleteSingleitem(id);
        if (d == true) {
            elist.remove(a);


        } else {
            Toast.makeText(context, "unble to delete", Toast.LENGTH_SHORT).show();
        }

    }

}
