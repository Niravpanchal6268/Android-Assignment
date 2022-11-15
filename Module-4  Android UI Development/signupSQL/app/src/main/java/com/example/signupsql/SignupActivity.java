package com.example.signupsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText s_username, s_email, s_password;

    Button l_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        s_username = findViewById(R.id.s_username_id);
        s_email = findViewById(R.id.s_email_id);
        s_password = findViewById(R.id.s_password_id);
        l_signUp = findViewById(R.id.sign_btn_id);
        Helper_database  helper_database=  new Helper_database(this);

        l_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usern, seamil, spass;
                usern = s_username.getText().toString();
                seamil = s_email.getText().toString();
                spass = s_password.getText().toString();

                if (usern.equals("")||seamil.equals("")||spass.equals(""))
                {
                    Toast.makeText(SignupActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    boolean i= helper_database.checkEmail(seamil);
                    if (i==false)
                    {
                        boolean insertfun= helper_database.insert_recored(usern,seamil,spass);
                        if (insertfun==true)
                        {
                            Toast.makeText(SignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this,home.class));

                        }
                        else {
                            Toast.makeText(SignupActivity.this, "Failed to signup", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this, "Please  choose another email", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
}