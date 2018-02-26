package com.master.qualitydepartment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by hufan on 2018/1/22.
 */

public class UniversallyTitle extends RelativeLayout {
    private RelativeLayout rl_root;
    private Button titleBack;
    private TextView titleText;
    private TextView titleText2;
    public UniversallyTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        rl_root = findViewById(R.id.rl_root);
        titleBack=(Button)findViewById(R.id.btn_title_back);
        titleText=(TextView)findViewById(R.id.tv_title);
        titleText2=(TextView)findViewById(R.id.tv_Sentitle);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
    public void setTitleText(String text){
        titleText.setText(text);
    }
    public void setTitleText(int id){
        titleText.setText(id);
    }
    public void setTitleText2(String text){
        titleText2.setText(text);
    }
    public void setTitleText2(int id){
        titleText2.setText(id);
    }
    //设置title的返回键图标
    public void setBtnBg(int id){
        Drawable drawable = this.getResources().getDrawable(id);
        titleBack.setBackground(drawable);
    }

    public void setTextColor(int color) {
        titleText.setTextColor(color);
        titleText2.setTextColor(color);
    }

    public void setBackground(int id) {
        Drawable drawable = this.getResources().getDrawable(id);
        rl_root.setBackground(drawable);
    }

    public void setBackgroundColor(int color) {
        rl_root.setBackgroundColor(color);
    }
}
