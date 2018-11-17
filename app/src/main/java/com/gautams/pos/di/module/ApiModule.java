package com.gautams.pos.di.module;

import com.gautams.pos.api.UserApi;
import com.gautams.pos.database.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * User Name: gautams2
 * Create Date : 9/7/2018
 */

@Module
public class ApiModule {


    @Provides
    @Singleton
    public UserApi userApi(Retrofit retrofit) {
        return retrofit.create(UserApi.class);
    }

}
