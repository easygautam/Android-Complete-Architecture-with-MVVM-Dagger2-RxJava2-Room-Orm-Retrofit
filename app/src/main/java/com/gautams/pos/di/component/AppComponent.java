package com.gautams.pos.di.component;

import com.gautams.pos.POSApplication;
import com.gautams.pos.view.ActivityModule;
import com.gautams.pos.di.module.ApiModule;
import com.gautams.pos.di.module.AppModule;
import com.gautams.pos.di.module.databse.RoomModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * User_1 Name: gautams2
 * Create Date : 5/30/2018
 */
@Singleton
@Component(
        modules = { // add all modules
                AndroidSupportInjectionModule.class, // provides android injection
                AppModule.class, // provide application level objects i.e - context, etc
                ActivityModule.class,
                RoomModule.class,
                ApiModule.class,
        })
public abstract class AppComponent {

    public abstract void inject(POSApplication application); // Allow to inject AppComponent in POSApplication class

}
