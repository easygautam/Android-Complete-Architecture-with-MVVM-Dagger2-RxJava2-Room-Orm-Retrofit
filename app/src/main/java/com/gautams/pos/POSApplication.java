package com.gautams.pos;

import android.app.Activity;
import android.app.Application;

import com.gautams.pos.di.component.DaggerAppComponent;
import com.gautams.pos.di.module.AppModule;
import com.gautams.pos.network.Broadcaster;
import com.gautams.pos.network.NetworkError;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * User_1 Name: gautams2
 * Create Date : 5/30/2018
 */
public class POSApplication extends Application implements HasActivityInjector{

    private Broadcaster<NetworkError> networkErrorBroadcaster;

    private static POSApplication instance;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;

        DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build()
                .inject(this);

        networkErrorBroadcaster = new Broadcaster<NetworkError>();

    }

    public Broadcaster<NetworkError> getNetworkErrorBroadcaster() {
        return networkErrorBroadcaster;
    }

    public static POSApplication getInstance() {
        return instance;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
