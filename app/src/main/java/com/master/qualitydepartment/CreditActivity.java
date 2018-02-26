package com.master.qualitydepartment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CreditActivity extends AppCompatActivity {
    private Context context = CreditActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        UniversallyTitle title = findViewById(R.id.title_credit);
        title.setTitleText("信用");
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            // TODO: 2018/2/1 完成点击监听功能
            case R.id.tv_credit_record:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.tv_credit_rule:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
