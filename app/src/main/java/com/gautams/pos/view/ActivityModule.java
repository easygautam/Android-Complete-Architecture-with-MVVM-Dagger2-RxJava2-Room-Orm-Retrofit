package com.gautams.pos.view;

import com.gautams.pos.view.login.LoginActivity;
import com.gautams.pos.view.login.LoginActivityModule;
import com.gautams.pos.view.splash.SplashActivity;
import com.gautams.pos.view.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * User_1 Name: gautams2
 * Create Date : 5/31/2018
 */
@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {SplashActivityModule.class})
    abstract SplashActivity mainActivity();

    @ContributesAndroidInjector(modules = {LoginActivityModule.class})
    abstract LoginActivity issueListActivity();


}
