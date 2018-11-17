package com.gautams.pos.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.gautams.pos.database.entity.User;

import java.util.List;

/**
 * User_1 Name: gautams2
 * Create Date : 9/7/2018
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("SELECT * from User")
    LiveData<List<User>> getAllUser();

    @Query("SELECT * from User WHERE id=:userId")
    LiveData<List<User>> getUserById(Long userId);

}
