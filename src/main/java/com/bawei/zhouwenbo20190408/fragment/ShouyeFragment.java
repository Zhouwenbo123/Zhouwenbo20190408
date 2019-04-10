package com.bawei.zhouwenbo20190408.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bawei.zhouwenbo20190408.R;
import com.bawei.zhouwenbo20190408.adapter.MyFragmentAdapter;
import com.bawei.zhouwenbo20190408.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: Machenike
 * Date: 2019/4/8 9:09,周文博
 * Description:
 */
public class ShouyeFragment  extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager1;
    private List<Fragment> list;
    private ArrayList<String> title = new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.fragment_shouye;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        //创建Fragment集合
            list = new ArrayList<>();
            list.add(new fragment1());
            list.add(new fragment2());
            list.add(new fragment3());
            list.add(new fragment4());
            list.add(new fragment5());
            list.add(new fragment6());
            list.add(new fragment7());
            for (int i=0;i<7;i++){
                title.add("标题"+i);
            }
            viewPager1.setAdapter(new MyFragmentAdapter(getChildFragmentManager(),list,title));
            tabLayout.setupWithViewPager(viewPager1);





    }

    @Override
    protected void initView() {
        viewPager1 = bindView(R.id.viewpager1);
        tabLayout = bindView(R.id.tablayout);


    }

}
