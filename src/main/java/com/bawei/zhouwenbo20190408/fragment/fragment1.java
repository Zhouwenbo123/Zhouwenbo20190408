package com.bawei.zhouwenbo20190408.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.zhouwenbo20190408.R;
import com.bawei.zhouwenbo20190408.adapter.MyBaseAdapter;
import com.bawei.zhouwenbo20190408.base.BaseFragment;
import com.bawei.zhouwenbo20190408.bean.JsonBean;
import com.bawei.zhouwenbo20190408.util.HttpUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: Machenike
 * Date: 2019/4/8 9:09,周文博
 * Description:
 */
public class fragment1 extends BaseFragment {
    private String listUrl = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=5";
    private PullToRefreshListView listView;
    private ArrayList<JsonBean.Result> list1;
    private List<String>  imagerUrl;
    private  MyBaseAdapter adapter;
    private Banner banner;
    @Override
    protected int initLayout() {

        return R.layout.fragment1;
    }

    @Override
    protected void initListener() {
       listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
           @Override
           public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

           }

           @Override
           public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

           }
       });
    }

    @Override
    protected void initData() {
        HttpUtils.httpAsynTask(listUrl, new HttpUtils.CallBack() {
            @Override
            public void getData(String s) {
                list1 = getArrayData(s);
                //设置适配器
                adapter = new MyBaseAdapter(list1,getActivity());
                listView.setAdapter(adapter);

                banner.setImages(imagerUrl);
                banner.setDelayTime(1000);
                banner.setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                });
                banner.start();
            }
        });


    }

    @Override
    protected void initView() {
        listView = bindView(R.id.listview);
        banner = bindView(R.id.banner);
        imagerUrl = new ArrayList<>();
        imagerUrl.add("http://172.17.8.100/images/small/banner/cj.png");
        imagerUrl.add("http://172.17.8.100/images/small/banner/lyq.png");
        imagerUrl.add("http://172.17.8.100/images/small/banner/px.png");
        imagerUrl.add("http://172.17.8.100/images/small/banner/wy.png");

    }
    public ArrayList<JsonBean.Result> getArrayData(String s) {
        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(s, JsonBean.class);
        List<JsonBean.Result> news = jsonBean.getResult();
        ArrayList<JsonBean.Result> ones = new ArrayList<>();
        ones.addAll(news);
        return ones;
    }
}
