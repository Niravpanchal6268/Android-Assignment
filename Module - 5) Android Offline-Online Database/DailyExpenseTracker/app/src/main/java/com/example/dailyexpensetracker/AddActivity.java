package com.example.dailyexpensetracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.math.BigInteger;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {

    TextInputLayout expence, title, description, date;
    Button add;
    ImageView cal;
    TextToSpeech texttospeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("Add Expense");
        expence = findViewById(R.id.expence_id);
        title = findViewById(R.id.title_id);
        description = findViewById(R.id.description_id);
        add = findViewById(R.id.add_item_btn_id);
        date = findViewById(R.id.date_id);
        cal = findViewById(R.id.calendar_id);

        //
        Calendar calendar = Calendar.getInstance(); //for current date
        String cdate = DateFormat.getDateInstance().format(calendar.getTime());
        date.getEditText().setText(cdate);

        ////
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar1 = Calendar.getInstance();
                int year = calendar1.get(Calendar.YEAR);
                int month = calendar1.get(Calendar.MONTH);
                int day = calendar1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        date.getEditText().setText(day + "/" + (month + 1) + "/" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        Database_class database_class = new Database_class(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Expence = expence.getEditText().getText().toString().trim();
                String Title = title.getEditText().getText().toString().trim();
                String Descriotion = description.getEditText().getText().toString().trim();
                String Date = date.getEditText().getText().toString();

                if (Expence.isEmpty() || Title.isEmpty() || Descriotion.isEmpty()) {
                    Toast.makeText(AddActivity.this, "Fill all the fileds", Toast.LENGTH_SHORT).show();

                } else {


                    boolean u = database_class.insertdate(BigInteger.valueOf(Long.parseLong(expence.getEditText().getText().toString())), Title, Descriotion, Date);
                    if (u == true) {
                        Toast.makeText(AddActivity.this, "not add", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(AddActivity.this, "Add successfully", Toast.LENGTH_SHORT).show();
                        texttospeak = new TextToSpeech(AddActivity.this, new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int i) {
                                if (i == texttospeak.SUCCESS) {
                                    texttospeak.setLanguage(Locale.ENGLISH);
                                    texttospeak.speak(Expence + "rupee", TextToSpeech.QUEUE_FLUSH, null);


                                }
                            }
                        });

                        startActivity(new Intent(AddActivity.this, MainActivity.class));
                        finish();

                    }

                }


            }
        });


    }

}