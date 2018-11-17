package com.gautams.pos.network;

import android.content.Context;
import android.support.annotation.NonNull;

import com.gautams.pos.POSApplication;
import com.gautams.pos.R;
import com.gautams.pos.utils.Utilities;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * User Name: gautams2
 * Create Date : 9/22/2018
 */
public class NetworkConnectionInterceptor implements Interceptor {

    private Context context;

    public NetworkConnectionInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (!isInternetAvailable()) {
            onInternetUnavailable();
        }
        return chain.proceed(request);
    }

    private boolean isInternetAvailable() {
        return Utilities.isNetworkAvailable(context);
    }

    private void onInternetUnavailable() {
        ((POSApplication) context)
                .getNetworkErrorBroadcaster()
                .send(new NetworkError(NetworkError.INTERNET_CONNECTION_ERROR, context.getString(R.string.internet_connection_error)));
    }
}