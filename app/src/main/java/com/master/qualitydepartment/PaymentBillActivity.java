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
 * 03管理01缴费账单
 */

public class PaymentBillActivity extends AppCompatActivity {

    private Button btn_payment_bill_immPay;
    private Context context = PaymentBillActivity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_bill);
        //2018/2/9 设置标题
        UniversallyTitle title = findViewById(R.id.title_payment_bill);
        title.setTitleText("缴费账单");

        btn_payment_bill_immPay=findViewById(R.id.btn_payment_bill_immPay);
        btn_payment_bill_immPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //2018/2/7 “立即缴费”按钮的监听事件，跳转至（ImmediatelyPayActivity.class）
                Intent intent=new Intent(context,ImmediatelyPayActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
