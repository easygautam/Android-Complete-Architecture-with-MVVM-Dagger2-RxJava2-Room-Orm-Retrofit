package com.gautams.pos.api;


import com.gautams.pos.database.entity.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * User Name: gautams2
 * Create Date : 9/13/2018
 */
public interface UserApi {

    @GET("/users")
    Flowable<List<User>> getAllIUsers();


}
