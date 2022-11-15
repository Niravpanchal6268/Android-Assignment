package com.example.colorchangewithradiobtn;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RadioButton r,y,b;
    RadioGroup radioGroup;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=findViewById(R.id.radio_g_id);
        r=findViewById(R.id.red_id);
        y=findViewById(R.id.yellow);
        b=findViewById(R.id.blue_id);
        linearLayout=findViewById(R.id.layout_id);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (r.isChecked())
                {
                    linearLayout.setBackgroundColor(Color.RED);
                    Toast.makeText(MainActivity.this, "red", Toast.LENGTH_SHORT).show();
                }
                else if (y.isChecked())
                {
                    linearLayout.setBackgroundColor(Color.YELLOW);
                    Toast.makeText(MainActivity.this, "yellow", Toast.LENGTH_SHORT).show();
                }
                else if (b.isChecked())
                {
                    linearLayout.setBackgroundColor(Color.BLUE);
                    Toast.makeText(MainActivity.this, "blue", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}