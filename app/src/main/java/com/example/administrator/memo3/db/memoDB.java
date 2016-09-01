package com.example.administrator.memo3.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.administrator.memo3.model.Amuse;
import com.example.administrator.memo3.model.Live;
import com.example.administrator.memo3.model.Study;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class memoDB {
    private static final String DB_NAME = "memo_database";
    public static final int VERSION = 1;
    private static memoDB memodb;
    private SQLiteDatabase db;

    public memoDB(Context context){
        myDatabaseHelper dbHelper = new myDatabaseHelper(context,DB_NAME,null,VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public static memoDB getInstance(Context context){
        if(memodb == null){
            memodb = new memoDB(context);
        }
        return memodb;
    }

    public void test(){
        String str = "ues for test";
        ContentValues values = new ContentValues();
        values.put("amuse_content",str);
        db.insert("Amuse",null,values);
        Log.d("TAG","this is test");
    }

    public void saveStudy(String str){
        if(str != null){
            ContentValues values = new ContentValues();
            values.put("study_content",str);

           /* Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            String DATE = year+"_"+month+"_"+day;
            values.put("study_date",DATE);*/
            db.insert("Study",null,values);
        }
    }

    public String getStudyDate(String content){
        String DATA = null;
        Cursor cursor = db.query("Study",null,"study_date = ?",new String[]{content},null,null,null);
        DATA = cursor.getString(cursor.getColumnIndex("study_date"));
        return DATA;
    }

    public List<Study> loadStudy(){
        List<Study> list = new ArrayList<Study>();
        Cursor cursor = db.query("Study",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Study study = new Study();
                study.setId(cursor.getInt(cursor.getColumnIndex("id")));
                study.setContent(cursor.getString(cursor.getColumnIndex("study_content")));
               // study.setContent(cursor.getString(cursor.getColumnIndex("study_date")));
                list.add(study);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void updataStudy(String source,String target){
        ContentValues values = new ContentValues();
        values.put("study_content",target);
        db.update("Study",values,"study_content = ?",new String[]{source});

    }

    public void delStudy(String str){
        db.delete("Study","study_content = ?", new String[]{str});
    }

    public void saveAmuse(String str){
        if(str != null){
            ContentValues values = new ContentValues();
            values.put("amuse_content",str);
            db.insert("Amuse",null,values);
        }
    }

    public List<Amuse> loadAmuse(){
        List<Amuse> list = new ArrayList<Amuse>();
        Cursor cursor = db.query("Amuse",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Amuse amuse = new Amuse();
                amuse.setId(cursor.getInt(cursor.getColumnIndex("id")));
                amuse.setContent(cursor.getString(cursor.getColumnIndex("amuse_content")));
                list.add(amuse);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void updataAmuse(String source,String target){
        ContentValues values = new ContentValues();
        values.put("amuse_content",target);
        db.update("Amuse",values,"amuse_content = ?",new String[]{source});
    }

    public void delAmuse(String str){
        db.delete("Amuse","amuse_content = ?",new String[]{str});
    }

    public void saveLive(String str){
        if(str != null){
            ContentValues values = new ContentValues();
            values.put("live_content",str);
            db.insert("Live",null,values);
        }
    }

    public List<Live> loadLive(){
        List<Live> list = new ArrayList<Live>();
        Cursor cursor = db.query("Live",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Live live = new Live();
                live.setId(cursor.getInt(cursor.getColumnIndex("id")));
                live.setContent(cursor.getString(cursor.getColumnIndex("live_content")));
                list.add(live);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void updataLive(String source,String target){
        ContentValues values = new ContentValues();
        values.put("live_content",target);
        db.update("Live",values,"live_content = ?",new String[]{source});
    }

    public void delLive(String str){
        db.delete("Live","live_content = ?",new String[]{str});
    }

}
