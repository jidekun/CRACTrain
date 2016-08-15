package com.dgh.dgh.cractrain.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dgh.dgh.cractrain.R;
import com.dgh.dgh.cractrain.bean.QBean;
import com.dgh.dgh.cractrain.utils.EasyToast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main2Activity extends AppCompatActivity {

    private ViewPager vp;
    private ArrayList<QBean> mList;
    private int i = 1;

    private ProgressBar pb;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            vp.setCurrentItem(i++);
            pb.setProgress(i);
            EasyToast.show(Main2Activity.this, i + "");
            handler.sendEmptyMessageDelayed(0, 100);
            int count = qAda.getCount();
            if (i >= count) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    };
    private QAda qAda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        mList = (ArrayList<QBean>) getIntent().getSerializableExtra("list");
        qAda = new QAda(this, mList);
        vp.setAdapter(qAda);
        handler.sendEmptyMessageDelayed(0, 5000);
        pb.setMax(qAda.getCount());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        pb = (ProgressBar) findViewById(R.id.pb);
        mList = new ArrayList<>();
    }

    class QAda extends PagerAdapter {
        @InjectView(R.id.tv_q)
        TextView tvQ;
        @InjectView(R.id.iv)
        ImageView iv;
        @InjectView(R.id.rb_a)
        AppCompatCheckBox rbA;
        @InjectView(R.id.tv_a)
        TextView tvA;
        @InjectView(R.id.rb_b)
        AppCompatCheckBox rbB;
        @InjectView(R.id.tv_b)
        TextView tvB;
        @InjectView(R.id.rb_c)
        AppCompatCheckBox rbC;
        @InjectView(R.id.tv_c)
        TextView tvC;
        @InjectView(R.id.rb_d)
        AppCompatCheckBox rbD;
        @InjectView(R.id.tv_d)
        TextView tvD;
        private Context context;
        private ArrayList<QBean> list;

        public QAda(Context context, ArrayList<QBean> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View inflate = View.inflate(context, R.layout.qitem, null);
            ButterKnife.inject(this, inflate);
            QBean qBean = list.get(position);
            tvQ.setText("问题 : "+qBean.q);
            tvA.setText("A : "+qBean.a);
            tvB.setText("B : "+qBean.b);
            tvC.setText("C : "+qBean.c);
            tvD.setText("D : "+qBean.d);
            container.addView(inflate);
            return inflate;
        }
    }
}
