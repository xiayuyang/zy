package com.example.administrator.zy.Adapter;

/**
 * Created by Administrator on 2018/5/27.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.zy.Fragment.MyFragment;

/**
     * 自定义fragment适配器
     *
     */
    public class MyFragmentPageAdapter extends FragmentPagerAdapter {
        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return 17;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MyFragment.newInstance(position+1);
                case 1:
                    return MyFragment.newInstance(position+1);
                case 2:
                    return MyFragment.newInstance(position+1);
                case 3:
                    return MyFragment.newInstance(position+1);
                case 4:
                    return MyFragment.newInstance(position+1);
                case 5:
                    return MyFragment.newInstance(position+1);
                case 6:
                    return MyFragment.newInstance(position+1);
                case 7:
                    return MyFragment.newInstance(position+1);
                case 8:
                    return MyFragment.newInstance(position+1);
                case 9:
                    return MyFragment.newInstance(position+1);
                case 10:
                    return MyFragment.newInstance(position+1);
                case 11:
                    return MyFragment.newInstance(position+1);
                case 12:
                    return MyFragment.newInstance(position+1);
                case 13:
                    return MyFragment.newInstance(position+1);
                case 14:
                    return MyFragment.newInstance(position+1);
                case 15:
                    return MyFragment.newInstance(position+1);
                case 16:
                    return MyFragment.newInstance(position+1);
                default:
                    return null;
            }
        }
    }

