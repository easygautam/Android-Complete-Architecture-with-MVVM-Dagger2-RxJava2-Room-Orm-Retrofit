package com.gautams.pos.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gautams.pos.network.NetworkConnectionInterceptor;
import com.gautams.pos.config.AppConstant;
import com.gautams.pos.network.ResponseErrorInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * User_1 Name: gautams2
 * Create Date : 5/31/2018
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context context() {
        return context;
    }

    @Singleton
    @Provides
    @Named("ISSUE_API_BASE_URL")
    public String issueApiBaseUrl(Context context) {
        return AppConstant.ISSUE_API_BASE_URL;
    }

    @Singleton
    @Provides
    public Gson gson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    @Singleton
    @Provides
    public OkHttpClient okHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new NetworkConnectionInterceptor(context))
                .addInterceptor(new ResponseErrorInterceptor())
                .build();
    }


    @Singleton
    @Provides
    public Retrofit retrofit(@Named("ISSUE_API_BASE_URL") String issueApiBaseUrl, Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(issueApiBaseUrl)
                .build();
    }

}
