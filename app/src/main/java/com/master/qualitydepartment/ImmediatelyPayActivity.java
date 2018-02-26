package com.master.qualitydepartment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 03管理02立即缴费
 */

public class ImmediatelyPayActivity extends Activity {
    private CheckBox cb_ernting;
    private Button bt_immediate_all;
    private EditText input_bought;
    private CheckBox cb_water;
    private EditText inoput_clectic;
    private CheckBox cb_electic;
    private TextView tv_add;
    private TextView tv_all_end;
    private Context context = ImmediatelyPayActivity.this;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immediately_pay);
        // 2018/2/9 设置标题
        UniversallyTitle title = findViewById(R.id.title_immediate_payment );
        title.setTitleText("立即缴费");

        cb_ernting = findViewById(R.id.cb_rent);
        bt_immediate_all = findViewById(R.id.immedite_payment_all);
        input_bought = findViewById(R.id.input_bought_money);
        cb_water = findViewById(R.id.cb_water_cost);
        inoput_clectic = findViewById(R.id.input_money);
        cb_electic = findViewById(R.id.cb_electic_cost);
        tv_add = findViewById(R.id.tv_add_money);
        tv_all_end = findViewById(R.id.tv_all);

        bt_immediate_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"立即缴费",Toast.LENGTH_SHORT).show();
                // 2018/2/7 跳转至（PaymentActivity.class）
                Intent intent=new Intent(context,PaymentActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        cb_water.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    input_bought.setEnabled(true);
                }else{
                    input_bought.setEnabled(false);
                }
            }
        });

       cb_electic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked){
                   inoput_clectic.setEnabled(true);
               }else{
                   inoput_clectic.setEnabled(false);
               }
           }
       });

       tv_add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (input_bought != null);{
                   tv_add = input_bought;
               }
           }
       });

    }
}
