package com.chendong.game.textfuzion.model.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SaveCallback;
import com.avos.avoscloud.SignUpCallback;
import com.chendong.game.textfuzion.MyCallBack;
import com.chendong.game.textfuzion.model.ITFModel;

/**
 * Created by 63484 on 2016/8/25.
 */
public class TFModel implements ITFModel{


    @Override
    public void register(String account, String password,String email, final MyCallBack callBack) {
        AVUser user = new AVUser();// 新建 AVUser 对象实例
        user.setUsername(account);// 设置用户名
        user.setPassword(password);// 设置密码
        user.setEmail(email);// 设置邮箱
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    callBack.onSuccess(null);
                } else {
                    callBack.onError(e.toString());
                }
            }
        });
    }

    @Override
    public void login(String account, String password, final MyCallBack callBack) {
        AVUser.logInInBackground(account, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                if (e==null){
                    callBack.onSuccess(avUser.getUsername());
                }else {
                    callBack.onError(e.toString());
                }
            }
        });
    }
}
