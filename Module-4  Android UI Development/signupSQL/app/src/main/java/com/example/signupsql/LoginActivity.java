package com.example.signupsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText lemail, lpassword;
    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lemail = findViewById(R.id.l_email_id);
        lpassword = findViewById(R.id.l_password_id);
        login = findViewById(R.id.login_btn_id);
        signup = findViewById(R.id.sign_up_btn_id);

            Helper_database helper_database= new Helper_database(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em, pass;

                em = lemail.getText().toString();
                pass = lpassword.getText().toString();
                if (em.equals("")||pass.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Fill all  the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean validate= helper_database.checkEmailPassword(em,pass);
                    if (validate==true)
                    {
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,home.class));
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                    }

                }


            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

    }
}