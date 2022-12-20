package com.example.dailyexpensetracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton add_btn;
    RecyclerView recyclerView;
    ArrayList<model> elist;
    TextView totalA;
    RelativeLayout relativeLayout;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_btn = findViewById(R.id.add_btn_ic);
        recyclerView = findViewById(R.id.recycleview);
        totalA = findViewById(R.id.total_amount_id);
        Database_class database_class = new Database_class(this);
        relativeLayout = findViewById(R.id.Main_Relativelayout_id);


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Cursor cursor = new Database_class(this).showdate();
        elist = new ArrayList<>();
        while (cursor.moveToNext()) {
            model s = new model(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            elist.add(s);
        }
        myAdapter = new MyAdapter(elist, this);
        recyclerView.setAdapter(myAdapter);
//        String Total = database_class.totalamount();  // string dat store



        try {
            ItemTouchHelper helper = new ItemTouchHelper(callback);
            helper.attachToRecyclerView(recyclerView);
            totalA.setText(String.format("Total:" + database_class.totalamount()));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

//        MenuItem item=menu.findItem(R.id.search_id);
//        SearchView searchView= (SearchView) item.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//
//                MyAdapter myAdapter= new MyAdapter(elist);
//                myAdapter.filter.filter(s);
//                return false;
//            }
//        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.clear_id) {
            clearall();
        }

        return super.onOptionsItemSelected(item);

    }

    private void clearall() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete");
        builder.setIcon(R.drawable.ic_baseline_delete_24);
        builder.setCancelable(true);
        builder.setMessage("are you sure to clear all the data");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Database_class database_class = new Database_class(MainActivity.this);
                database_class.deleteall();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                finish();
            }
        });
        builder.setNeutralButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();

    }

    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            Snackbar snackbar = Snackbar.make(relativeLayout, "Item Delete", Snackbar.LENGTH_LONG);
            myAdapter.delete(viewHolder.getAdapterPosition());

            myAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            snackbar.show();

        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
        MainActivity.this.finish();
        System.exit(0);
    }

}