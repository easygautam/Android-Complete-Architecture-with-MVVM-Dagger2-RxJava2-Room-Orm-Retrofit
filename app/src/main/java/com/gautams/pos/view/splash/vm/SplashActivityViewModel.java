package com.gautams.pos.view.splash.vm;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;

import com.gautams.pos.repository.UserRepository;
import com.gautams.pos.view.login.LoginActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * User_1 Name: gautams2
 * Create Date : 9/7/2018
 */
public class SplashActivityViewModel extends ViewModel {


    private UserRepository userRepository;

    CompositeDisposable disposable = new CompositeDisposable();

    public SplashActivityViewModel() {


    }

    public void startIssueListActivity(Context context) {
        disposable.add(Observable
                .just("Hello")
                .ignoreElements()
                .timeout(2, TimeUnit.SECONDS)
                // Delay the results for at least half a second
                .delay(500, TimeUnit.MILLISECONDS)
                // Subscribe work on separate thread, if not already
                .subscribeOn(Schedulers.io())
                // Bring it back to the UI thread!!
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }));
    }


    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
