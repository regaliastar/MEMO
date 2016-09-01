package com.example.administrator.memo3.test;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.memo3.R;


/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class Test extends Activity {

    private TextView test_view;
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

    }
}
