package com.master.qualitydepartment.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.master.qualitydepartment.CreditActivity;
import com.master.qualitydepartment.PaymentBillActivity;
import com.master.qualitydepartment.PointsActivity;
import com.master.qualitydepartment.R;
import com.master.qualitydepartment.SettingActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 注册登陆界面
 * 如果在“管理界面”已经注册，则直接显示Tab导航视图
 * Tab导航条管理3个fragment
 */
public class ManageFragment extends Fragment implements View.OnClickListener{

    private View ll_manage_title;
    private View xml_manage_login;
    private View xml_manage_booking;
    private View xml_manage_precontract;
    private View xml_manage_signing;
    private RadioButton btn_manage_precontract;
    private RadioButton btn_manage_booking;
    private RadioButton btn_manage_signing;

    GridView mGrid;

    int [] ImageIds={R.drawable.ic_my_contract,R.drawable.ic_bill_payment,R.drawable.ic_intelligent_door_lock,
            R.drawable.ic_clean_service,R.drawable.ic_apply_repair,R.drawable.ic_want_complain,
            R.drawable.ic_renew_my_lease,R.drawable.ic_withdraw_my_rent,R.drawable.ic_user_handbook};

    public ManageFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_manage, container, false);
        view.findViewById(R.id.btn_manage_login).setOnClickListener(this);//02管理登陆按钮
        view.findViewById(R.id.btn_manage_precontract).setOnClickListener(this);
        view.findViewById(R.id.btn_manage_booking).setOnClickListener(this);
        view.findViewById(R.id.btn_manage_signing).setOnClickListener(this);
        //3个radio button
        btn_manage_precontract=view.findViewById(R.id.btn_manage_precontract);
        btn_manage_booking =view.findViewById(R.id.btn_manage_booking);
        btn_manage_signing=view.findViewById(R.id.btn_manage_signing);
        //预约界面的“预约成功”TextView,字体颜色可修改
        view.findViewById(R.id.tv_success_precontract).setOnClickListener(this);
        //签约界面的“额外费用”隐藏线性布局
        view.findViewById(R.id.tv_sign_extra_cost).setOnClickListener(this);
        //找到五个include进去的布局文件
        ll_manage_title=view.findViewById(R.id.ll_manage_title);// TODO: 2018/2/9 此处有笔记
        xml_manage_booking=view.findViewById(R.id.xml_manage_booking);
        xml_manage_login=view.findViewById(R.id.xml_manage_login);
        xml_manage_precontract=view.findViewById(R.id.xml_manage_precontract);
        xml_manage_signing=view.findViewById(R.id.xml_manage_signing);
        //2018/2/7 gridview填充数据
        initGrids(view);
        return view;
    }

    private void initGrids(View view) {
        String[] titles = getResources().getStringArray(R.array.manage);
        mGrid = view.findViewById(R.id.gv_signing);
        initGridView(mGrid,ImageIds, titles);//生成GridView
        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //跳转界面
                Intent intent=null;
                switch (position) {
                    case 0:
                        Toast.makeText(getActivity(), "跳转到我的合同", Toast.LENGTH_LONG).show();
                        break;
                    case 1://2018/2/7 其中“账单缴费”的监听事件 ，跳转到“缴费账单”活动
                        intent = new Intent(getContext(), PaymentBillActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        break;
//                    case 2:
//                        break;
                    default:
                        break;
                }
                if(intent!=null){
                    startActivity(intent);
                }

            }
        });

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_manage_login:
                xml_manage_login.setVisibility(View.GONE);
                ll_manage_title.setVisibility(View.VISIBLE);//title总是显示
                xml_manage_precontract.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_manage_precontract:
                Toast.makeText(getActivity(),"这是预约界面",Toast.LENGTH_SHORT).show();
                xml_manage_booking.setVisibility(View.GONE);
                xml_manage_signing.setVisibility(View.GONE);
                xml_manage_precontract.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_manage_booking:
                Toast.makeText(getActivity(),"这是预定界面",Toast.LENGTH_SHORT).show();
                xml_manage_signing.setVisibility(View.GONE);
                xml_manage_precontract.setVisibility(View.GONE);
                xml_manage_booking.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_manage_signing:
                Toast.makeText(getActivity(),"这是签约界面",Toast.LENGTH_SHORT).show();
                xml_manage_precontract.setVisibility(View.GONE);
                xml_manage_booking.setVisibility(View.GONE);
                xml_manage_signing.setVisibility(View.VISIBLE);
                break;
        }
    }
}
