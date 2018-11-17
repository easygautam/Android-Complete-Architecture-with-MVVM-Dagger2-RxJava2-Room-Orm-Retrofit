package com.gautams.pos.repository;

import com.gautams.pos.api.UserApi;
import com.gautams.pos.database.dao.UserDao;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * User_1 Name: gautams2
 * Create Date : 9/7/2018
 */
public class UserRepository {

    private final String TAG = getClass().getSimpleName();

    private UserApi userApi;
    private UserDao userDao;
    private Disposable disposable;

    @Inject
    public UserRepository(
            UserApi userApi,
            UserDao userDao
    ) {
        this.userApi = userApi;
        this.userDao = userDao;
    }

}
