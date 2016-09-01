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
import com.example.administrator.memo3.model.Amuse;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class amuseList extends Activity {

    private memoDB memo_db;
    private List<Amuse> data;
    private Button saveButton;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.memo_list);
        memo_db = new memoDB(this);
       // memo_db.test();
        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = " ";
                Intent intent = new Intent(amuseList.this,saveContent.class);
                intent.putExtra("amuse_data",str);
                startActivity(intent);
            }
        });
        data = memo_db.loadAmuse();
        Collections.reverse(data);

        ArrayAdapter<Amuse> adapter = new ArrayAdapter<Amuse>(amuseList.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Amuse amuse = data.get(i);
                String content = amuse.getContent();
                Intent intent = new Intent(amuseList.this,memoContent.class);
                intent.putExtra("amuse_data",content);
                startActivity(intent);
                amuseList.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        memo_db = new memoDB(this);
        data = memo_db.loadAmuse();
        Collections.reverse(data);

        ArrayAdapter<Amuse> adapter = new ArrayAdapter<Amuse>(amuseList.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy");
    }
}
