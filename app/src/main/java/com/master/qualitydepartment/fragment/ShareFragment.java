package com.master.qualitydepartment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.master.qualitydepartment.R;


/**
 * A simple {@link Fragment} subclass.
 * 通过改变TextView字体的颜来实现双Tab的效果
 * 采用Fragment中放Fragment的策略
 */
public class ShareFragment extends Fragment {


    public ShareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share, container, false);
    }

}
