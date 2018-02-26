package com.master.qualitydepartment.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.master.qualitydepartment.ContractActivity;
import com.master.qualitydepartment.CreditActivity;
import com.master.qualitydepartment.PointsActivity;
import com.master.qualitydepartment.R;
import com.master.qualitydepartment.SettingActivity;
import com.master.qualitydepartment.WalletActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = "MeFragment";

    GridView grid_order;
    GridView grid_privilege;

    int [] orderImageIds = new int[] {
            R.drawable.ic_appointment, R.drawable.ic_book, R.drawable.ic_contract
    };

    int [] privilegeImageIds = new int[] {
            R.drawable.ic_credit, R.drawable.ic_points, R.drawable.ic_bonus, R.drawable.ic_coupon
    };


    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        view.findViewById(R.id.btn_settins).setOnClickListener(this);
        view.findViewById(R.id.civ_profile).setOnClickListener(this);
        view.findViewById(R.id.ll_login_register).setOnClickListener(this);
        view.findViewById(R.id.ll_authentation).setOnClickListener(this);
        view.findViewById(R.id.tv_wallet).setOnClickListener(this);
        view.findViewById(R.id.tv_collection).setOnClickListener(this);
        view.findViewById(R.id.tv_us).setOnClickListener(this);
        initGrids(view);
        return view;
    }

    private void initGridView(GridView grid_order, int[] imageIds, String[] titles) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", imageIds[i]);
            item.put("title", titles[i]);
            listItems.add(item);
        }

        SimpleAdapter orderAdapter = new SimpleAdapter(getActivity(), listItems,
                R.layout.grid_cell, new String[] {"image", "title"}, new int[] {R.id.iv_grid_item, R.id.tv_grid_item});
        grid_order.setAdapter(orderAdapter);
    }

    private void initGrids(View view) {
        String[] titles = getResources().getStringArray(R.array.orders);
        grid_order = view.findViewById(R.id.gv_order);
        initGridView(grid_order, orderImageIds, titles);//生成GridView
        grid_order.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //跳转界面
                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        Toast.makeText(getActivity(), "跳转到预约页面", Toast.LENGTH_LONG).show();
//                        intent.setClass(getContext(), AAActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
                        break;
                    case 1:
//                        intent = new Intent(getContext(), BBActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
                        break;
                    case 2:
//                        intent.setClass(getContext(), AAActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
                        break;

                }
            }
        });

        titles = getResources().getStringArray(R.array.privileges);
        grid_privilege = view.findViewById(R.id.gv_privilege);
        initGridView(grid_privilege, privilegeImageIds, titles);
        grid_privilege.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //跳转界面
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(getContext(), CreditActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    case 1:
//                        intent = new Intent(getContext(), PointsActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getContext(), PointsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    case 3:
//                        intent.setClass(getContext(), AAActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
                        break;

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            // TODO: 2018/2/1 完成点击监听功能
            case R.id.btn_settins:
                intent = new Intent(getContext(), SettingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.civ_profile:
                break;
            case R.id.ll_login_register:
                Toast.makeText(getActivity(), "跳转到登录页面", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_authentation:
                break;
            case R.id.tv_wallet:
                intent = new Intent(getContext(), WalletActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.tv_collection:
                break;
            case R.id.tv_us:
                intent = new Intent(getContext(), ContractActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            default:
                break;
        }
// TODO: 2018/2/4 统一处理startActivity(intent);
        if (intent != null) {
            startActivity(intent);
        }
    }
}
