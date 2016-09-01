package com.example.administrator.memo3.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.memo3.R;
import com.example.administrator.memo3.db.memoDB;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class memoContent extends Activity {

    private EditText textView;
    private Button saveButton;
    private Button delButton;
    private memoDB memo_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_content);
        memo_db = new memoDB(this);
        textView = (EditText) findViewById(R.id.textView);
        saveButton = (Button) findViewById(R.id.save_button);
        delButton = (Button) findViewById(R.id.del_button);
        String data = null;
        int Type = 0;

        Intent intent = getIntent();
        if(intent.getStringExtra("study_data") != null){
            data = intent.getStringExtra("study_data");
            Log.d("TAG","study_data载入成功");
            Type = 1;
        }
        if(intent.getStringExtra("amuse_data") != null){
            data = intent.getStringExtra("amuse_data");
            Log.d("TAG","amuse_data载入成功");
            Type = 2;
        }
        if(intent.getStringExtra("live_data") != null){
            data = intent.getStringExtra("live_data");
            Log.d("TAG","live_data载入成功");
            Type = 3;
        }

        textView.setText(data);

        final int finalType = Type;
        final String finalData = data;
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = (String) textView.getText().toString();
                switch (finalType){
                    case 1:
                        memo_db.updataStudy(finalData,str);
                        Intent intent1 = new Intent(memoContent.this,studyList.class);
                        startActivity(intent1);
                        memoContent.this.finish();
                        break;
                    case 2:
                        memo_db.updataAmuse(finalData,str);
                        Intent intent2 = new Intent(memoContent.this,amuseList.class);
                        startActivity(intent2);
                        memoContent.this.finish();
                        break;
                    case 3:
                        memo_db.updataLive(finalData,str);
                        Intent intent3 = new Intent(memoContent.this,liveList.class);
                        startActivity(intent3);
                        memoContent.this.finish();
                        break;
                    default:
                        Log.d("TAG","存储失败");
                        break;

                }
            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = (String) textView.getText().toString();
                switch (finalType){
                    case 1:
                        memo_db.delStudy(str);
                        Intent intent1 = new Intent(memoContent.this,studyList.class);
                        startActivity(intent1);
                        memoContent.this.finish();
                        break;
                    case 2:
                        memo_db.delAmuse(str);
                        Intent intent2 = new Intent(memoContent.this,amuseList.class);
                        startActivity(intent2);
                        memoContent.this.finish();
                        break;
                    case 3:
                        memo_db.delLive(str);
                        Intent intent3 = new Intent(memoContent.this,liveList.class);
                        startActivity(intent3);
                        memoContent.this.finish();
                        break;
                    default:
                        Log.d("TAG","删除失败");
                        break;

                }
            }
        });
    }
}
