package com.gautams.pos.view.login.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Log;

import com.gautams.pos.model.Store;
import com.gautams.pos.repository.UserRepository;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;

/**
 * User Name: gautams2
 * Create Date : 9/13/2018
 */
public class LoginActivityViewModel extends ViewModel {

    private final String TAG = getClass().getSimpleName();

    private UserRepository userRepository;

    public ObservableList<Store> stores = new ObservableArrayList<>();

    public ObservableBoolean dataLoading = new ObservableBoolean();

    private CompositeDisposable disposable;

    public LoginActivityViewModel() {
        disposable = new CompositeDisposable();
        dataLoading.set(Boolean.TRUE);

//        stores.set(new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            stores.add(new Store("Select Store "+ i));
        }

    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    private void fetchIssuesFromServer() {
//        disposable.add(userRepository.fetchIssuesFromServer()
//                .subscribe(
//                        issue -> {
//                        },
//                        this::fetchError,
//                        this::fetchDone));
//    }

    private void fetchError(Throwable throwable) {
        if (throwable instanceof ConnectException) {
            ConnectException connectException = (ConnectException) throwable;
        }
        else if (throwable instanceof HttpException) {
            HttpException error = (HttpException) throwable;
            Log.d(TAG, "fetchError: error code " + error.code());
        }
        Log.d(TAG, "fetchIssuesFromServer: error ");
        dataLoading.set(Boolean.FALSE);
    }

    private void fetchDone() {
        Log.d(TAG, "fetchIssuesFromServer: completed ");
        dataLoading.set(Boolean.FALSE);
    }



    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }



}
