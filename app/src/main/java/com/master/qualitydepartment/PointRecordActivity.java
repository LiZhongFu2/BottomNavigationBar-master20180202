package com.master.qualitydepartment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 积分记录活动
 */
public class PointRecordActivity extends AppCompatActivity {
    private ListView lvRecord;

    private List<Map<String, String>> recordList;
    private final String[] Keys = new String[]{"title", "date", "point_change"};

    private String[] recordTitles = new String[]{"每日签到", "分享文章", "积分兑换优惠券"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_record);

        intitListData();

        UniversallyTitle title = findViewById(R.id.title_point_record);
        title.setTitleText("积分记录");

        lvRecord = findViewById(R.id.lv_point_record);
        SimpleAdapter adapter = new SimpleAdapter(this, recordList,
                R.layout.point_list_item,
                new String[]{Keys[0], Keys[1], Keys[2]},
                new int[]{R.id.tv_item_title, R.id.tv_item_date, R.id.tv_point_change}
        );
        lvRecord.setAdapter(adapter);
        View emptyView = findViewById(R.id.tv_list_empty_view);
        lvRecord.setEmptyView(emptyView);
    }

    private void intitListData() {
        // TODO: 2018/2/4 仿照fragment_me封装成一个方法
        recordList = new ArrayList<>();
        Map<String, String> item = new HashMap<>();
        item.put(Keys[0], recordTitles[0]);
        item.put(Keys[1], "2017-12-25");
        item.put(Keys[2], "+10");
        recordList.add(item);

        item = new HashMap<>();
        item.put(Keys[0], recordTitles[1]);
        item.put(Keys[1], "2017-12-22");
        item.put(Keys[2], "+30");
        recordList.add(item);

        item = new HashMap<>();
        item.put(Keys[0], recordTitles[2]);
        item.put(Keys[1], "2017-12-15");
        item.put(Keys[2], "-500");
        recordList.add(item);

        item = new HashMap<>();
        item.put(Keys[0], recordTitles[0]);
        item.put(Keys[1], "2017-12-14");
        item.put(Keys[2], "+10");
        recordList.add(item);

        item = new HashMap<>();
        item.put(Keys[0], recordTitles[0]);
        item.put(Keys[1], "2017-12-13");
        item.put(Keys[2], "+10");
        recordList.add(item);

        item = new HashMap<>();
        item.put(Keys[0], recordTitles[0]);
        item.put(Keys[1], "2017-12-12");
        item.put(Keys[2], "+10");
        recordList.add(item);

        item = new HashMap<>();
        item.put(Keys[0], recordTitles[1]);
        item.put(Keys[1], "2017-12-12");
        item.put(Keys[2], "+30");
        recordList.add(item);
    }
}
