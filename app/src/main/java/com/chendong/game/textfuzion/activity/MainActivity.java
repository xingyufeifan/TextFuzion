package com.chendong.game.textfuzion.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chendong.game.textfuzion.R;
import com.chendong.game.textfuzion.present.ITFRegisterPresenter;
import com.chendong.game.textfuzion.present.impl.TFRegisterPrensenter;

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

    }

    @Override
    public void register() {
        Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void faile(String error) {
        Toast.makeText(this,"注册失败:"+error,Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_register)
    public void onClick() {
        String account=etAccount.getText().toString();
        String password=etPassword.getText().toString();
        itfLoginPresenter.login(account, password);
    }
}
