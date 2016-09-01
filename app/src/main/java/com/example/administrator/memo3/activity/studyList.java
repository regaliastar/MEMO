package com.example.administrator.memo3.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.memo3.R;
import com.example.administrator.memo3.db.memoDB;
import com.example.administrator.memo3.model.Study;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class studyList extends Activity {

    private memoDB memo_db;
    private Button saveButton;

    private List<Study> data;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.memo_list);
        memo_db = new memoDB(this);
        //memo_db.test();
        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = " ";
                Intent intent = new Intent(studyList.this,saveContent.class);
                intent.putExtra("study_data",str);
                startActivity(intent);
            }
        });

        data = memo_db.loadStudy();
        Collections.reverse(data);

        ArrayAdapter<Study> adapter = new ArrayAdapter<Study>(studyList.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Study study = data.get(i);
                String content = study.getContent();
                Intent intent = new Intent(studyList.this,memoContent.class);
                intent.putExtra("study_data",content);
                startActivity(intent);
                studyList.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        memo_db = new memoDB(this);
        data = memo_db.loadStudy();
        Collections.reverse(data);

        ArrayAdapter<Study> adapter = new ArrayAdapter<Study>(studyList.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy");
    }
}
