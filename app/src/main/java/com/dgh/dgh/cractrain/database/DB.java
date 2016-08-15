package com.dgh.dgh.cractrain.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dgh.dgh.cractrain.bean.QBean;

import java.util.ArrayList;


/**
 * Created by JDK on 2016/8/9.
 */
public class DB {
    private DBHelper helper;
    private String tableA = "a";              //数据库表名
    private String tableB = "b";
    private String tableC = "c";
    private String num = "num";               //题目序号          必填
    private String numTitle = "numTitle";     //题目完整序号
    private String q = "q";                   //问题               必填
    private String a = "a";                   // 必填
    private String b = "b";                   // 必填
    private String c = "c";                   // 必填
    private String d = "d";                   // 必填
    private String e = "e";
    private String f = "f";
    private String g = "g";
    private String hasImg = "hasImg";         //是否有图片 true false   必填
    private String hasMulti = "hasMulti";     //是否为多选 true false   必填
    private String key = "key";               //正确答案                必填
    private String mode = "mode";             //模式
    private String Img = "Img";               //图片
    private Context context;

    public DB(Context context) {
        this.context = context;
        helper = new DBHelper(context);
    }


    public long add(int num, String q, String a, String b, String c, String d) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(this.num, num);
        v.put(this.q, q);
        v.put(this.a, a);
        v.put(this.b, b);
        v.put(this.c, c);
        v.put(this.d, d);
        v.put(this.hasImg, false);
        v.put(this.hasMulti, false);
        v.put(this.key, "a");
        long insert = db.insert(tableA, null, v);
        db.close();//关闭数据库释放资源
        return insert;
    }

    public ArrayList<QBean> findAll() {
        ArrayList<QBean> list = new ArrayList<QBean>();
        SQLiteDatabase db = helper.getWritableDatabase();
        //按照count 降序排列
        Cursor cursor = db.query(tableA, null, null, null, null, null, null);
        QBean QBean = null;
        while (cursor.moveToNext()) {
            QBean = new QBean();
            int num = cursor.getInt(cursor.getColumnIndex(this.num));
            String q = cursor.getString(cursor.getColumnIndex(this.q));
            String a = cursor.getString(cursor.getColumnIndex(this.a));
            String b = cursor.getString(cursor.getColumnIndex(this.b));
            String c = cursor.getString(cursor.getColumnIndex(this.c));
            String d = cursor.getString(cursor.getColumnIndex(this.d));
            QBean.num = num;
            QBean.q = q;
            QBean.a = a;
            QBean.b = b;
            QBean.c = c;
            QBean.d = d;
            list.add(QBean);
        }
        cursor.close();
        db.close();
        return list;
    }
}
