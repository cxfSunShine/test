package com.example.administrator.myapplication2.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication2.R;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by Administrator on 2017/3/2.
 */

public class FragmentWifi extends Fragment {

    private TextView text = null;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pager_one, container, false);

        initViews();
        return view;
    }

    private void initViews() {
        text = (TextView) view.findViewById(R.id.page_one_text);
        text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "123", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
