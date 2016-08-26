package com.chendong.game.textfuzion.activity;

import android.app.Activity;
import android.os.Bundle;

import com.avos.avoscloud.AVAnalytics;

import butterknife.ButterKnife;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/8/25 - 15:00
 * 注释：
 */
public abstract class BaseActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AVAnalytics.trackAppOpened(getIntent());
        ButterKnife.bind(this);

        initData();
        initView();
    }








    protected abstract void initView();

    public abstract void initData();
}
