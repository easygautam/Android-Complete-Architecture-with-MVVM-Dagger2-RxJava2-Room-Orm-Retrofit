package com.gautams.pos.di.module.databse;

import android.content.Context;

import com.gautams.pos.database.AppDatabase;
import com.gautams.pos.database.dao.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * User_1 Name: gautams2
 * Create Date : 9/7/2018
 */

@Module
public class RoomModule {

    @Singleton
    @Provides
    public AppDatabase appDatabase(Context context) {
        return AppDatabase.getDatabase(context);
    }

    @Provides
    @Singleton
    public UserDao userDao(AppDatabase appDatabase) {
        return appDatabase.userDao();
    }

}
