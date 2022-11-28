package com.example.todo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    FloatingActionButton addButton;
    EditText title, des, date;
    ImageView cal;
    Button taskadd;
    RecyclerView recyclerView;
    ArrayList<model> tlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        DataBaseClassnew db = new DataBaseClassnew(HomeActivity.this);
        recyclerView = findViewById(R.id.recyclerview_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Cursor cursor = db.showdata();
        tlist = new ArrayList<>();
        while (cursor.moveToNext()) {
            model obj = new model(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3));
            tlist.add(obj);
        }
        Adapter_Class adapter_class = new Adapter_Class(tlist,getBaseContext());
        recyclerView.setAdapter(adapter_class);
        adapter_class.notifyDataSetChanged();


        addButton = findViewById(R.id.add_btn_id);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(HomeActivity.this);
                dialog.setTitle("Add Title");
                dialog.setContentView(R.layout.add_dialog);
                dialog.setCancelable(true);
                title = dialog.findViewById(R.id.task_title_id);
                des = dialog.findViewById(R.id.task_descri_id);
                date = dialog.findViewById(R.id.date_id);
                taskadd = dialog.findViewById(R.id.task_add_btn_id);
                cal=dialog.findViewById(R.id.cal_imge_id);
                Calendar calendar = Calendar.getInstance();
                String dset = DateFormat.getDateInstance().format(calendar.getTime());
                date.setText(dset);
                cal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Calendar calendar1 = Calendar.getInstance();
                        int year = calendar1.get(Calendar.YEAR);
                        int month = calendar1.get(Calendar.MONTH);
                        int day = calendar1.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog datePickerDialog=new DatePickerDialog(HomeActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                date.setText(day+"/"+month+"/"+year);


                            }
                        },year,month,day);
                        datePickerDialog.show();

                    }
                });
                taskadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String Title = title.getText().toString();
                        String Des = des.getText().toString();
                        String Date = date.getText().toString();


                        if (Title.isEmpty() || Des.isEmpty() || Date.isEmpty()) {
                            Toast.makeText(HomeActivity.this, "Fill all the fileds", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(HomeActivity.this, "fill ", Toast.LENGTH_SHORT).show();
                           boolean s= db.insertdate(Title, Des, Date);
                            if (s==true)
                            {
                                Toast.makeText(HomeActivity.this, "fail to add", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(HomeActivity.this, "add", Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(HomeActivity.this,HomeActivity.class));
                               finish();
                            }
                        }
                    }
                });

                dialog.show();
            }
        });
    }
}