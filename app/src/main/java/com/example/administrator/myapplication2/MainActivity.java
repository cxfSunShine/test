package com.example.administrator.myapplication2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.myapplication2.adapter.MyViewPagerAdapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.main_tab)
    private TabLayout tabLayout = null;
    @ViewInject(R.id.main_pager)
    private ViewPager viewPager = null;
    private MyViewPagerAdapter pagerAdapter = null;
    private List<View> list = null;
    private View pageOne = null;
    private View pageTwo = null;
    private View pageThree = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        init();
    }

    private void init() {
        list = new ArrayList<>();
        pagerAdapter = new MyViewPagerAdapter(list);
        LayoutInflater inflater = LayoutInflater.from(this);
        pageOne = inflater.inflate(R.layout.pager_one, null);
        pageTwo = inflater.inflate(R.layout.pager_two, null);
        pageThree = inflater.inflate(R.layout.pager_three, null);
        list.add(pageOne);
        list.add(pageTwo);
        list.add(pageThree);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);

    }
}
