package com.bawei.zhouwenbo20190408;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.zhouwenbo20190408.base.BaseActivity;
import com.bawei.zhouwenbo20190408.fragment.MyFragment;
import com.bawei.zhouwenbo20190408.fragment.ShouyeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager viewPager;
    private RadioGroup radio_group;
    private List<Fragment> list;


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        list = new ArrayList<>();
        list.add(new ShouyeFragment());
        list.add(new MyFragment());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radio_group.check(radio_group.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.but1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.but2:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });

    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewpager);
        radio_group = findViewById(R.id.radio_group);

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
}
