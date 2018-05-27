package com.example.administrator.zy.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.zy.Adapter.MyFragmentPageAdapter;
import com.example.administrator.zy.R;

public class Kebiao1Activity extends AppCompatActivity {
ImageButton imageButton;

/*

*/
    private ViewPager mViewPager;
    private MyFragmentPageAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebiao1);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        //这里因为是3.0一下版本，所以需继承FragmentActivity，通过getSupportFragmentManager()获取FragmentManager
        //3.0及其以上版本，只需继承Activity，通过getFragmentManager获取事物
        FragmentManager fm = getSupportFragmentManager();
        //初始化自定义适配器
        mAdapter =  new MyFragmentPageAdapter(fm);
        //绑定自定义适配器
        mViewPager.setAdapter(mAdapter);
      imageButton = (ImageButton)findViewById(R.id.more1);
      imageButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(Kebiao1Activity.this,YouWenActivity.class);
              startActivity(intent);
              finish();
          }
      });
      /*

*/


    }
}
