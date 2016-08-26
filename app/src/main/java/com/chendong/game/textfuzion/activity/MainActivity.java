package com.chendong.game.textfuzion.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.chendong.game.textfuzion.R;
import com.chendong.game.textfuzion.presenter.ITFRegisterPresenter;
import com.chendong.game.textfuzion.presenter.impl.TFRegisterPrensenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IVIew {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private ITFRegisterPresenter itfLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        itfLoginPresenter = new TFRegisterPrensenter(this);
    }

    @Override
    public void login() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        // TODO: 2016/8/26 跳转到角色列表 
    }

    @Override
    public void register() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void faile(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.btn_register, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                new MaterialDialog.Builder(this)
                        .title("注册")
                        .customView(R.layout.dialog_register_custom_view,true)
                        .negativeText("取消")
                        .positiveText("确定")
                        .positiveColorRes(R.color.md_edittext_error)
                        .negativeColorRes(R.color.colorPrimary)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                EditText etAccount= (EditText) dialog.findViewById(R.id.register_account);
                                EditText etPassword= (EditText) dialog.findViewById(R.id.register_password);
                                EditText etEmail= (EditText) dialog.findViewById(R.id.register_mail);
                                String account=etAccount.getText().toString();
                                String password=etPassword.getText().toString();
                                String email=etEmail.getText().toString();
                                etAccount.setText(account);
                                etPassword.setText(password);
                                itfLoginPresenter.register(account,password,email);
                            }
                        }).show();
                break;
            case R.id.btn_login:
                itfLoginPresenter.login(etAccount.getText().toString(),etPassword.getText().toString());
                break;
        }
    }
}
