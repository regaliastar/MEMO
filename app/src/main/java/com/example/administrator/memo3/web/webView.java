package com.example.administrator.memo3.web;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.memo3.R;


/**
 * Created by Administrator on 2016/8/21 0021.
 */
public class webView extends Activity {

    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("webView","0");
        setContentView(R.layout.web_view);
        Log.d("webView","1");
        webview = (WebView) findViewById(R.id.web_view);
        Log.d("webView","2");
        webview.getSettings().setJavaScriptEnabled(true);
        Log.d("webView","3");
        webview.setWebViewClient(new WebViewClient());
        Log.d("webView","4");
        webview.loadUrl("http://www.baidu.com");
        Log.d("webView","5");
    }

    @Override
    protected void onStop() {
        super.onStop();
        webView.this.finish();
    }
}
