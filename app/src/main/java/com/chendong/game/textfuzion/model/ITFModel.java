package com.chendong.game.textfuzion.model;

import com.chendong.game.textfuzion.MyCallBack;

/**
 * Created by 63484 on 2016/8/25.
 */
public interface ITFModel {
    void login(String account, String password, MyCallBack callBack);
}
