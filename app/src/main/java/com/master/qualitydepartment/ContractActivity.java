package com.master.qualitydepartment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 联系我们界面
 */
public class ContractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        UniversallyTitle title = findViewById(R.id.title_contract);
        title.setTitleText("联系我们");
    }
}
