package com.master.qualitydepartment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.master.qualitydepartment.widget.switchbutton.SwitchButton;

public class SettingActivity extends AppCompatActivity {
    private Context context = SettingActivity.this;
    private SwitchButton sbMusic;
    private SwitchButton sbVibration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        UniversallyTitle title = findViewById(R.id.title_setting);
        title.setTitleText("设置");

        sbMusic = findViewById(R.id.switch_music);
        sbVibration = findViewById(R.id.switch_vibration);
        sbMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sbVibration.setChecked(!b);
            }
        });
        sbVibration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sbMusic.setChecked(!b);
            }
        });
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            // TODO: 2018/2/1 完成点击监听功能
            case R.id.ll_user_basic_info:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.tv_setting_password:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.ll_music:
//                intent = new Intent(context, AActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(context, "Music!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_clean_cache:
                break;
            case R.id.tv_feedback:
                break;
            case R.id.ll_update:
                break;
            case R.id.tv_about_us:
                break;
            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
