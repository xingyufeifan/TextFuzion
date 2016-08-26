package com.chendong.game.textfuzion.presenter.impl;

import com.chendong.game.textfuzion.MyCallBack;
import com.chendong.game.textfuzion.activity.IVIew;
import com.chendong.game.textfuzion.model.ITFModel;
import com.chendong.game.textfuzion.model.impl.TFModel;
import com.chendong.game.textfuzion.presenter.ITFRegisterPresenter;

/**
 * Created by 63484 on 2016/8/25.
 */
public class TFRegisterPrensenter implements ITFRegisterPresenter {
    private ITFModel itfModel;
    private IVIew ivIew;
    public TFRegisterPrensenter(IVIew ivIew) {
        this.itfModel=new TFModel();
        this.ivIew=ivIew;
    }

    @Override
    public void register(String account, String password,String email) {
        itfModel.register(account, password,email, new MyCallBack() {
            @Override
            public void onSuccess(String data) {
                ivIew.register();
            }

            @Override
            public void onError(String error) {
                ivIew.faile(error);
            }
        });
    }

    @Override
    public void login(String account, String password) {
        itfModel.login(account, password, new MyCallBack() {
            @Override
            public void onSuccess(String data) {
                ivIew.login();
            }

            @Override
            public void onError(String error) {
                ivIew.faile(error);
            }
        });
    }

}
