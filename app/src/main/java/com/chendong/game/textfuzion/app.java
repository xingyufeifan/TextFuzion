package com.chendong.game.textfuzion;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/8/25 - 14:52
 * 注释：
 */
public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "xeXETAbvMLJ1ajtDPiDAaCvN-gzGzoHsz", "eAaRHaFFqQSg9OmKrNK7zH4M");

    }


}
