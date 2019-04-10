package com.bawei.zhouwenbo20190408.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.zhouwenbo20190408.R;
import com.bawei.zhouwenbo20190408.base.BaseFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: Machenike
 * Date: 2019/4/8 9:09,周文博
 * Description:
 */
public class MyFragment extends BaseFragment {
    private ImageView image_title;
    private  WebView webView;
    private String file = Environment.getExternalStorageState()+"/bb.png";
    @Override
    protected int initLayout() {

        return R.layout.fragment_my;
    }

    @Override
    protected void initListener() {
            image_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    alertPath();

                }
            });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        image_title = bindView(R.id.image_title);
        webView = bindView(R.id.webview);
    }


    public void  alertPath(){
       AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

       builder.setTitle("上传工具");
       String item[] = {"相册"};
       builder.setItems(item, new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Intent intent = new Intent(Intent.ACTION_PICK);
               intent.setType("image/*");
               startActivityForResult(intent,100);
           }
       });
       builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            Uri uri = Uri.fromFile(new File(file));
            Crop(uri);
        }else if(requestCode == 200){
            Bitmap bitmap = data.getParcelableExtra("data");
            Glide.with(this).load(bitmap).apply(RequestOptions.centerInsideTransform()).apply(RequestOptions.circleCropTransform()).into(image_title);
        }
    }

    public void  Crop(Uri uri){
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri,"image/*");
        intent.putExtra("crop",true);
        intent.putExtra("aspectX",1);
        intent.putExtra("aspectY",1);
        intent.putExtra("outputX",250);
        intent.putExtra("outputY",250);
        intent.putExtra("return-data",true);
        startActivityForResult(intent,200);

    }
}
