package com.example.passdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView flname,uname,ph,gd,work,address,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        flname=findViewById(R.id.V_name_id);
        uname=findViewById(R.id.V_username_id);
        ph=findViewById(R.id.V_phone_id);
        age=findViewById(R.id.V_age_seek_id);
        gd=findViewById(R.id.V_gender_id);
        work=findViewById(R.id.V_work_id);
        address=findViewById(R.id.V_address_id);

        String N= getIntent().getStringExtra("n");
        String U= getIntent().getStringExtra("u");
        String A= getIntent().getStringExtra("g");
        String wor=getIntent().getStringExtra("w");
        String phone=getIntent().getStringExtra("p");
        String a=getIntent().getStringExtra("ag");
        String ads=getIntent().getStringExtra("as");


        flname.setText(N);
        uname.setText(U);
        gd.setText(A);
        age.setText(a);
        work.setText(wor);
        ph.setText(phone);
        address.setText(ads);


    }
}