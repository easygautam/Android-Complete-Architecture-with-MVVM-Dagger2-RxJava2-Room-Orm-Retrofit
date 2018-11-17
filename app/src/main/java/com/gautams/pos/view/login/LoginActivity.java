package com.gautams.pos.view.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gautams.pos.R;
import com.gautams.pos.databinding.ActivityLoginBinding;
import com.gautams.pos.utils.Utilities;

import com.gautams.pos.view.base.BaseActivity;
import com.gautams.pos.view.login.vm.LoginActivityViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * User Name: gautams2
 * Create Date : 9/10/2018
 */
public class LoginActivity extends BaseActivity {

    private final String TAG = getClass().getSimpleName();

    @Inject
    LoginActivityViewModel loginActivityViewModel;

    private ActivityLoginBinding binding;

    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLifecycleOwner(this);
        binding.setViewModel(loginActivityViewModel);

        handleError();
    }


    private void handleError() {
        disposable.add(Utilities.showNetworkError(this, binding.coordinatorLayout));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
