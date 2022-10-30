package com.example.myapplication;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatEditText;

public class intetnetchangeListener extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        if (!internet_class.isConnetedtointernet(context))   //internet not  conneted
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View layout_dialog = LayoutInflater.from(context).inflate(R.layout.check_internet, null);
            builder.setView(layout_dialog);


//            AppCompatEditText btnretry = layout_dialog.findViewById(R.id.retry_btn_id);
            AlertDialog alertDialog = builder.create();


            alertDialog.show();
            alertDialog.setCancelable(true);
            alertDialog.getWindow().setGravity(Gravity.CENTER);


//            btnretry.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    alertDialog.dismiss();
//                    onReceive(context, intent);
//                }
//            });

        }


    }
}
