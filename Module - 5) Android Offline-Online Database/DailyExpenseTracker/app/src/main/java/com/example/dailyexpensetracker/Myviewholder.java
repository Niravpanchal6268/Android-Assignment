package com.example.dailyexpensetracker;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Myviewholder extends RecyclerView.ViewHolder {

    TextView expence,title,des,date,Id;
    CardView singlecard;

    public Myviewholder(@NonNull View itemView) {
        super(itemView);
    expence=itemView.findViewById(R.id.expence_c_id);
    title=itemView.findViewById(R.id.title_c_id);
    date=itemView.findViewById(R.id.date_c_id);
    Id=itemView.findViewById(R.id.title_id_id);
    des=itemView.findViewById(R.id.description_c_id);
    singlecard=itemView.findViewById(R.id.mainLayout);

    }


}
