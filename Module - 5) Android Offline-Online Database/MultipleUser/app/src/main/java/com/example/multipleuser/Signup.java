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

public class Signup extends AppCompatActivity {

    EditText email, password, name;
    Button signbtn;
    Spinner usercategory;

    String usercat[] = {"Students", "Teacher", "Admin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        email = findViewById(R.id.sign_email_id);
        password = findViewById(R.id.sign_password_id);
        name = findViewById(R.id.sign_name_id);
        signbtn = findViewById(R.id.sign_btn_id);
        usercategory = findViewById(R.id.spinner_id);
        Student_DB db=new Student_DB(this);

        ArrayAdapter cat = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usercat);
        cat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        usercategory.setAdapter(cat);
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Category = usercategory.getSelectedItem().toString();


                if (Category == "Students") {
                    InsertStudents();
                } else if (Category == "Teacher") {

                } else if (Category == "Admin") {

                } else {

                }


//
            }

            private void InsertStudents() {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Category = usercategory.getSelectedItem().toString();
                boolean CE = db.CheckEmailStudent(Email, Category);
                if (CE == false) {

                    if (Name.isEmpty() || Email.isEmpty() || Password.isEmpty()) {
                        Toast.makeText(Signup.this, "Fill the filds", Toast.LENGTH_SHORT).show();
                    } else {

                        boolean i = db.SignStudent(Email, Password, Name, Category);
                        if (i == true) {

                            Toast.makeText(Signup.this, "Sign successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Signup.this, Login.class));
                        } else {

                            Toast.makeText(Signup.this, "sign fails", Toast.LENGTH_SHORT).show();
                        }

                    }
                } else {
                    Toast.makeText(Signup.this, "this Email already use try another Email", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}