package com.example.tablayout.tablayoutdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;

        ViewPager pager = (ViewPager) super.findViewById(R.id.pager);
        pager.setAdapter(new TabPagerAdapter(//
                Arrays.asList(Fragment.instantiate(context, Store.class.getName())//
                        , Fragment.instantiate(context, ItemFragment.class.getName())//
                        , Fragment.instantiate(context, Etc.class.getName()))));
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        //01
        tab.setupWithViewPager(pager);//tabitem added
        //02
        tab.getTabAt(0).setCustomView(LayoutInflater.from(context).inflate(R.layout.activity_main_tab_item0, tab, false));
        tab.getTabAt(1).setCustomView(LayoutInflater.from(context).inflate(R.layout.activity_main_tab_item1, tab, false));
        tab.getTabAt(2).setCustomView(LayoutInflater.from(context).inflate(R.layout.activity_main_tab_item2, tab, false));

    }

    public class TabPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments;
        public TabPagerAdapter(List fragments) {
            super(getSupportFragmentManager());
            mFragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
