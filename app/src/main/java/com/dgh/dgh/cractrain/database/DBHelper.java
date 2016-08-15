package com.dgh.dgh.cractrain.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jingjing on 16/8/11.
 */
public class DBHelper extends SQLiteOpenHelper {
    private String tableA="a";              //数据库表名
    private String tableB="b";
    private String tableC="c";
    private String num="num";               //题目序号          必填
    private String numTitle="numTitle";     //题目完整序号
    private String q="q";                   //问题               必填
    private String a="a";                   // 必填
    private String b="b";                   // 必填
    private String c="c";                   // 必填
    private String d="d";                   // 必填
    private String e="e";
    private String f="f";
    private String g="g";
    private String hasImg="hasImg";         //是否有图片 true false   必填
    private String hasMulti="hasMulti";     //是否为多选 true false   必填
    private String key="key";               //正确答案                必填
    private String mode="mode";             //模式
    private String Img="Img";               //图片

    public DBHelper(Context context) {
        super(context, "abc.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqla = "CREATE TABLE [a] (" +
                "[_id] integer PRIMARY KEY AUTOINCREMENT," +
                "[num] integer NOT NULL," +
                "[numTitle] varchar(30)," +
                "[q] varchar(200) NOT NULL," +
                "[a] varchar(200) NOT NULL," +
                "[b] varchar(200) NOT NULL," +
                "[c] varchar(200) NOT NULL," +
                "[d] varchar(200) NOT NULL," +
                "[e] varchar(200)," +
                "[f] varchar(200)," +
                "[g] varchar(200)," +
                "[hasImg] boolean NOT NULL," +
                "[hasMulti] boolean NOT NULL," +
                "[key] varchar(20) NOT NULL," +
                "[mode] varchar(20)," +
                "[Img] varchar(100))";
        String sqlb = "CREATE TABLE [a] (" +
                "[_id] integer PRIMARY KEY AUTOINCREMENT," +
                "[num] integer NOT NULL," +
                "[numTitle] varchar(30)," +
                "[q] varchar(200) NOT NULL," +
                "[a] varchar(200) NOT NULL," +
                "[b] varchar(200) NOT NULL," +
                "[c] varchar(200) NOT NULL," +
                "[d] varchar(200) NOT NULL," +
                "[e] varchar(200)," +
                "[f] varchar(200)," +
                "[g] varchar(200)," +
                "[hasImg] boolean NOT NULL," +
                "[hasMulti] boolean NOT NULL," +
                "[key] varchar(20) NOT NULL," +
                "[mode] varchar(20)," +
                "[Img] varchar(100))";
        String sqlc = "CREATE TABLE [a] (" +
                "[_id] integer PRIMARY KEY AUTOINCREMENT," +
                "[num] integer NOT NULL," +
                "[numTitle] varchar(30)," +
                "[q] varchar(200) NOT NULL," +
                "[a] varchar(200) NOT NULL," +
                "[b] varchar(200) NOT NULL," +
                "[c] varchar(200) NOT NULL," +
                "[d] varchar(200) NOT NULL," +
                "[e] varchar(200)," +
                "[f] varchar(200)," +
                "[g] varchar(200)," +
                "[hasImg] boolean NOT NULL," +
                "[hasMulti] boolean NOT NULL," +
                "[key] varchar(20) NOT NULL," +
                "[mode] varchar(20)," +
                "[Img] varchar(100))";
        sqLiteDatabase.execSQL(sqla);
//        sqLiteDatabase.execSQL(sqlb);
//        sqLiteDatabase.execSQL(sqlc);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
