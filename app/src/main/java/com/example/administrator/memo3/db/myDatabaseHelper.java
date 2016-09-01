package com.example.administrator.memo3.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class myDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_STUDY = "create table Study ( "
            + "id integer primary key autoincrement, "
            + "study_content text)";

    public static final String CREATE_AMUSE = "create table Amuse ( "
            + "id integer primary key autoincrement, "
            + "amuse_content text)";

    public static final String CREATE_LIVE = "create table Live ( "
            + "id integer primary key autoincrement, "
            + "live_content text)";

    public myDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STUDY);
        sqLiteDatabase.execSQL(CREATE_AMUSE);
        sqLiteDatabase.execSQL(CREATE_LIVE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
