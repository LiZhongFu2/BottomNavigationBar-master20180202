package com.master.qualitydepartment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * 我的钱包界面
 */
public class WalletActivity extends AppCompatActivity {
    private Context context = WalletActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        UniversallyTitle title = findViewById(R.id.title_wallet);
        title.setTitleText("我的钱包");
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            // TODO: 2018/2/1 完成点击监听功能
            case R.id.tv_recharge:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.tv_withdraw:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.tv_bingding_card:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(context, "绑定银行卡", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
