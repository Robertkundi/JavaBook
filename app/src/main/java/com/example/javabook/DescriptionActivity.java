package com.example.javabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DescriptionActivity extends AppCompatActivity {
public static final String TAG="DescriptionActivity";
private Context context;
private Bundle extras;
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        context= DescriptionActivity.this;
        webView=(WebView)findViewById(R.id.simpleWebView);
        extras=getIntent().getExtras();
        if(!extras.equals(null))
        {
            String data = extras.getString("titles");

            //String url="www.google.com";
            String url ="file:///android_asset/what_is_java.html";
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);



        }
    }
}