package com.gautams.pos.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.gautams.pos.database.dao.UserDao;
import com.gautams.pos.database.entity.User;

/**
 * User_1 Name: gautams2
 * Create Date : 9/7/2018
 */

@Database(entities = {
        User.class
}, version = AppDatabase.DATABASE_VERSION, exportSchema = false)
@TypeConverters({TimestampConverter.class})
public abstract class AppDatabase extends android.arch.persistence.room.RoomDatabase {

    //    Database version which define database schema version
    static final int DATABASE_VERSION = 1;

    //    Database known name
    private static final String DATABASE_NAME = "room_db";

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, AppDatabase.DATABASE_NAME)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

//    declare all dao
    public  abstract  UserDao userDao();



}
