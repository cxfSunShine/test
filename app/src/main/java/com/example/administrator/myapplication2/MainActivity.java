package com.example.administrator.myapplication2;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.administrator.myapplication2.adapter.MyViewPagerAdapter;
import com.example.administrator.myapplication2.fragment.FragmentFind;
import com.example.administrator.myapplication2.fragment.FragmentMessage;
import com.example.administrator.myapplication2.fragment.FragmentMine;
import com.example.administrator.myapplication2.fragment.FragmentWifi;
import com.example.administrator.myapplication2.fragment.MyFragmentPagerAdapter;
import com.example.administrator.myapplication2.view.ImmersedStatusbarUtils;
import com.example.administrator.myapplication2.view.StatusBarCompat;
import com.example.administrator.myapplication2.view.StatusUtils;

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
    private View pageFour = null;
    private MyFragmentPagerAdapter fragmentPagerAdapter = null;
    private ArrayList<Fragment> list_fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        x.view().inject(this);
        init();
        View topView = findViewById(R.id.lin);
        ImmersedStatusbarUtils.initAfterSetContentView(this, topView);
    }

    /**
     * 初始化控件和适配器
     **/
    private void init() {
        list = new ArrayList<>();
        list_fragment = new ArrayList<>();
        pagerAdapter = new MyViewPagerAdapter(list);
//        LayoutInflater inflater = LayoutInflater.from(this);
//        pageOne = inflater.inflate(R.layout.pager_one, null);
//        pageTwo = inflater.inflate(R.layout.pager_two, null);
//        pageThree = inflater.inflate(R.layout.pager_three, null);
//        pageFour = inflater.inflate(R.layout.pager_four, null);
//        list.add(pageOne);
//        list.add(pageTwo);
//        list.add(pageThree);
//        list.add(pageFour);
//        viewPager.setAdapter(pagerAdapter);
        //采用viewpager+fragment的方法来实现滑动切屏
        FragmentWifi fragmentWifi = new FragmentWifi();
        FragmentMessage fragmentMessage = new FragmentMessage();
        FragmentFind fragmentFind = new FragmentFind();
        FragmentMine fragmentMine = new FragmentMine();
        list_fragment.add(fragmentWifi);
        list_fragment.add(fragmentMessage);
        list_fragment.add(fragmentFind);
        list_fragment.add(fragmentMine);
        fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), list_fragment);
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
    }
}
