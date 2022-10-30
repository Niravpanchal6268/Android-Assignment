package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton A, S, M, D;
    EditText e1, e2;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioG_id);
        A = findViewById(R.id.add_id);
        S = findViewById(R.id.sub_id);
        M = findViewById(R.id.multi_id);
        D = findViewById(R.id.divi_id);
        e1 = findViewById(R.id.edit_id);
        e2 = findViewById(R.id.edit2_id);
        ans = findViewById(R.id.ans_id);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                String num = e1.getText().toString();
                String num2 = e2.getText().toString();

                int  v1 = Integer.parseInt(num);
                int v2 = Integer.parseInt(num2);

                String a = null;

                switch (i) {
                    case R.id.add_id:

                        a = String.valueOf(v1 + v2);
                        ans.setText(a);
                        break;
                    case R.id.sub_id:
                        a = String.valueOf(v1 - v2);
                        ans.setText(a);
                        break;

                    case R.id.multi_id:
                        a = String.valueOf(v1 * v2);
                        ans.setText(a);
                        break;
                    case R.id.divi_id:
                        if (v1 < v2) {

                            a = String.valueOf((float) v1 /(float) v2);

                            ans.setText("number bigger"+a);

                        } else {
                            a = String.valueOf((double) v1 /(double) v2);
                            ans.setText(a);
                        }

                }


            }
        });


    }
}