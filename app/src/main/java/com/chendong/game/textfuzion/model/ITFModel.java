package com.chendong.game.textfuzion.model;

import com.chendong.game.textfuzion.MyCallBack;

/**
 * Created by 63484 on 2016/8/25.
 */
public interface ITFModel {
    void register(String account, String password,String email, MyCallBack callBack);
    void login(String account,String password,MyCallBack callBack);
}
