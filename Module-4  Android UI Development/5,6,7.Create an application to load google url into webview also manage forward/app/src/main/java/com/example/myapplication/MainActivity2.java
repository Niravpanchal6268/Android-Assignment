package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView= findViewById(R.id.web_view_id);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.Google.com/");
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
        {
            webView.goBack();

        }
        else {
            super.onBackPressed();
            Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
        }

    }
}