package com.gautams.pos.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.gautams.pos.POSApplication;
import com.gautams.pos.network.NetworkError;

import io.reactivex.disposables.Disposable;

/**
 * User Name: gautams2
 * Create Date : 9/22/2018
 */
public class Utilities {

    public static boolean isNetworkAvailable(Context context) {
     ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public static Disposable showNetworkError(Activity activity, CoordinatorLayout coordinatorLayout){
        return  ((POSApplication) activity.getApplicationContext())
                .getNetworkErrorBroadcaster()
                .toObservable()
                .subscribe(networkError -> {
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, networkError.getMessage(), Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
                    sbView.setBackgroundColor(Color.RED);
                    textView.setTextColor(Color.WHITE);
                    snackbar.show();
                });

    }
}
