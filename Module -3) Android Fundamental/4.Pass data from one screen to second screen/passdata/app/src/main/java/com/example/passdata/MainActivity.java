package com.example.passdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText name, uname, phone, add;
    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox city, school, villege;
    Button register;
    SeekBar seekBar;
    TextView textView;
    String work;
   private String  age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name_id);
        uname = findViewById(R.id.username_id);
        phone = findViewById(R.id.phone_id);
        add = findViewById(R.id.address_id);
        radioGroup = findViewById(R.id.radio_group_id);
        city = findViewById(R.id.check_City_id);
        school = findViewById(R.id.check_school_id);
        villege = findViewById(R.id.check_Villege_id);
        register = findViewById(R.id.register_btn_id);
        seekBar = findViewById(R.id.seekbar_id);
        textView = findViewById(R.id.age_id);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                age= String.valueOf(i);
                textView.setText("Age: " + String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {


                String Name = name.getText().toString();
                String Uname = uname.getText().toString();
                String Phone = phone.getText().toString();
                String address = add.getText().toString();
                int select = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(select);
                String gender = radioButton.getText().toString();
                Toast.makeText(MainActivity.this, gender, Toast.LENGTH_SHORT).show();

                if (city.isChecked()) {
                    work += city.getText().toString();
                }
                if (school.isChecked()) {
                    work += school.getText().toString();
                }
                if (villege.isChecked()) {
                    work += villege.getText().toString();
                }

                String Work = work.toString();
                Intent i = new Intent(MainActivity.this, MainActivity2.class);

                i.putExtra("n", Name);
                i.putExtra("u", Uname);
                i.putExtra("g", gender);
                i.putExtra("w", Work);
                i.putExtra("p",Phone);
                i.putExtra("ag",age);
                i.putExtra("as",address);
                startActivity(i);


            }
        });



    }
}