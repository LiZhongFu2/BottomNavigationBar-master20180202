package com.master.qualitydepartment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by hufan on 2018/2/6.
 * 03管理03缴费
 */

public class PaymentActivity extends AppCompatActivity{

    private Button btn_payment_affirm;
    private Context context=PaymentActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        // 2018/2/9 设置标题
        UniversallyTitle title = findViewById(R.id.title_payment);
        title.setTitleText("缴费");

        btn_payment_affirm=findViewById(R.id.btn_payment_affirm);
        btn_payment_affirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转至主界面
                Intent intent=new Intent(context,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

    }
}
