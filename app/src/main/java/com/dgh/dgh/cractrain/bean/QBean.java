package com.dgh.dgh.cractrain.bean;

import java.io.Serializable;

/**
 * Created by jingjing on 16/8/11.
 */
public class QBean implements Serializable {

    public void QBean() {

    }

    public int num;               //题目序号          必填
    public String numTitle;     //题目完整序号
    public String q;                   //问题          必填
    public String a;                   // 必填
    public String b;                   // 必填
    public String c;                   // 必填
    public String d;                   // 必填
    public String e;
    public String f;
    public String g;
    public String hasImg;         //是否有图片 true false        必填
    public String hasMulti;     //是否为多选 true false          必填
    public String key;               //正确答案                  必填
    public String mode;             //模式
    public String Img;               //图片

    @Override
    public String toString() {
        return "QBean{" +
                "num=" + num +
                ", numTitle='" + numTitle + '\'' +
                ", q='" + q + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", e='" + e + '\'' +
                ", f='" + f + '\'' +
                ", g='" + g + '\'' +
                ", hasImg='" + hasImg + '\'' +
                ", hasMulti='" + hasMulti + '\'' +
                ", key='" + key + '\'' +
                ", mode='" + mode + '\'' +
                ", Img='" + Img + '\'' +
                '}';
    }
}
