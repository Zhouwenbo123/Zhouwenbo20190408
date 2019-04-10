package com.bawei.zhouwenbo20190408.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhouwenbo20190408.R;
import com.bawei.zhouwenbo20190408.bean.JsonBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: Machenike
 * Date: 2019/4/8 10:36,周文博
 * Description:
 */
public class MyBaseAdapter  extends BaseAdapter {
    private List<JsonBean.Result> list;
    private Context context;

    public MyBaseAdapter(List<JsonBean.Result> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.list_item,null);
            holder=new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView1);
            holder.text1 = convertView.findViewById(R.id.textview1);
            holder.text2 = convertView.findViewById(R.id.textview2);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text1.setText(list.get(position).getName());
        holder.text2.setText(list.get(position).getSummary());
        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.imageView);
        return convertView;
    }
    class  ViewHolder{
        ImageView imageView;
        TextView text1,text2;
    }
}
