package com.master.qualitydepartment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * 01积分界面
 */
public class PointsActivity extends AppCompatActivity {
    private Context context = PointsActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        UniversallyTitle title = findViewById(R.id.title_points);
        title.setTitleText("积分");
        title.setBtnBg(R.drawable.btn_back_white);
        title.setTextColor(Color.WHITE);
        title.setBackgroundColor(Color.TRANSPARENT);
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            // TODO: 2018/2/1 完成点击监听功能
            case R.id.tv_point_record:
                intent = new Intent(context, PointRecordActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.tv_point_exchange:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.tv_point_rule:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(context, "积分规则", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
