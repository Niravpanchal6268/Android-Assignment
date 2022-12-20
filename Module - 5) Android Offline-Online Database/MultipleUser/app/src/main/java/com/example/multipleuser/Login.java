package com.example.multipleuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multipleuser.Activity.AdminActivity;
import com.example.multipleuser.Activity.StudentHome;
import com.example.multipleuser.Activity.TeacherActivity;

public class Login extends AppCompatActivity {

    EditText email, password;
    Button loginbtn;
    Spinner category;
    String usercat[] = {"Students", "Teacher", "Admin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.login_email_id);
        password = findViewById(R.id.login_password_id);
        loginbtn = findViewById(R.id.login_btn_id);
        category = findViewById(R.id.Category_id);
        Student_DB db = new Student_DB(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, usercat);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String usercategory = category.getSelectedItem().toString();


                if (Email.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(Login.this, "fill the fileds", Toast.LENGTH_SHORT).show();
                } else {
                    boolean a = db.CheckStudents(Email, Password, usercategory);
                    if (a == true) {
                        Toast.makeText(Login.this, "log In", Toast.LENGTH_SHORT).show();
                        if (usercategory == "Students") {
                            Toast.makeText(Login.this, "As Student", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, StudentHome.class));
                        } else if (usercategory == "Teacher") {
                            startActivity(new Intent(Login.this, TeacherActivity.class));
                            Toast.makeText(Login.this, "As Teacher", Toast.LENGTH_SHORT).show();
                        } else if (usercategory == "Admin") {
                            Toast.makeText(Login.this, "As Admin", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, AdminActivity.class));
                        }
                    } else {
                        Toast.makeText(Login.this, "Wrong Email and Password Select Category", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });


    }

    public void monetising(View view) {

        startActivity(new Intent(Login.this, Signup.class));

    }
}