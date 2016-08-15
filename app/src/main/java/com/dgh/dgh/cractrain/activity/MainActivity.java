package com.dgh.dgh.cractrain.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dgh.dgh.cractrain.R;
import com.dgh.dgh.cractrain.bean.QBean;
import com.dgh.dgh.cractrain.database.DB;
import com.dgh.dgh.cractrain.database.DBHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bta,btb,btc;
    private TextView tv;
    private ArrayList<QBean> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        SQLiteDatabase.openOrCreateDatabase()
    }
    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        bta = (Button) findViewById(R.id.bta);
        btb=(Button) findViewById(R.id.btb);
        btc=(Button) findViewById(R.id.btc);
        bta.setOnClickListener(this);
        btb.setOnClickListener(this);
        btc.setOnClickListener(this);
        mList =new ArrayList<>();
    }

    private String readTxtForAssets(int i) {
        String fileName = "";
        String str = "";
        switch (i) {
            case 1:
                fileName = "a.txt";
                break;
            case 2:
                fileName = "b.txt";
                break;
            case 3:
                fileName = "c.txt";
                break;
        }
        try {
            InputStream is = this.getResources().getAssets().open(fileName);
            InputStreamReader isr = new InputStreamReader(is, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String s;
            QBean qBean = null;
            while ((s = br.readLine()) != null) {
                str += s + "\n";
                if (s.startsWith("卷面题数")||s.startsWith("涉及题数")||s.isEmpty()||s.startsWith("[P]")){
                    continue;
                }
                if (s.startsWith("[I]")){
                    if (qBean!=null){
                        mList.add(qBean);
                    }
                    qBean=new QBean();
                    qBean.num =Integer.parseInt(s.replace("[I]LK",""));
                }
                if (s.startsWith("[Q]")){
                    qBean.q=s.replace("[Q]","");
                }
                if (s.startsWith("[A]")){
                    qBean.a=s.replace("[A]","");
                }
                if (s.startsWith("[B]")){
                    qBean.b=s.replace("[B]","");
                }
                if (s.startsWith("[C]")){
                    qBean.c=s.replace("[C]","");
                }
                if (s.startsWith("[D]")){
                    qBean.d=s.replace("[D]","");
                }
            }
            DB db =new DB(this);
            for (QBean temp:mList){
                db.add(temp.num,temp.q,temp.a,temp.b,temp.c,temp.d);
            }
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return str;
        }

    }

    @Override
    public void onClick(View view) {
        int i=1;
        switch (view.getId()){
            case R.id.bta:
                i=1;
                break;
            case R.id.btb:
                i=2;
                break;
            case R.id.btc:
                i=3;
                break;
        }
        tv.setText("");
        final int finalI = i;
        new Thread() {
            @Override
            public void run() {
                final String s = readTxtForAssets(finalI);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        tv.setText(s);
                        Intent i =new Intent(MainActivity.this,Main2Activity.class);
                        i.putExtra("list",mList);
                        startActivity(i);
                    }
                });
            }
        }.start();
    }
}
