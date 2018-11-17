package com.gautams.pos.view.splash;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gautams.pos.R;
import com.gautams.pos.databinding.ActivitySplashBinding;
import com.gautams.pos.view.base.BaseActivity;
import com.gautams.pos.view.splash.vm.SplashActivityViewModel;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

    @Inject
    SplashActivityViewModel splashActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        activitySplashBinding.setViewModel(splashActivityViewModel);


        splashActivityViewModel.startIssueListActivity(this);


    }

}
