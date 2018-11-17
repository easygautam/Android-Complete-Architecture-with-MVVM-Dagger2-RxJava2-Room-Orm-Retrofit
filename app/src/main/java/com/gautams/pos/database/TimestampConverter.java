package com.gautams.pos.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * User Name: gautams2
 * Create Date : 9/10/2018
 */
public class TimestampConverter {
    // 2018-09-05 19:49:25.864000

    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }



}