package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_id);
        textView = findViewById(R.id.reverse_text_id);

        String text = editText.getText().toString();
        textView.setText(reverseString(text));
        System.out.println(reverseString(text));


    }

    public static String reverseString(String text) {
        char ch[] = text.toCharArray();
        String str = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            str += ch[i];
        }
        return str;
    }
}