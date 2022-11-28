package com.example.todo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class holder_view_class extends RecyclerView.ViewHolder {

    TextView title,desc,date,tsid;
    CheckBox checkBox;
    public holder_view_class(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.title_c_id);
        desc=itemView.findViewById(R.id.title_des_c_id);
        date=itemView.findViewById(R.id.date_c_id);
        tsid=itemView.findViewById(R.id.t_id);
        checkBox=itemView.findViewById(R.id.checkbox_done_c_id);
    }
}
