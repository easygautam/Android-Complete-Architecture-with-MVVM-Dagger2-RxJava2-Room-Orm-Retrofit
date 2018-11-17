package com.gautams.pos.network;

import android.support.annotation.NonNull;

import com.gautams.pos.POSApplication;
import com.gautams.pos.R;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * User Name: gautams2
 * Create Date : 9/22/2018
 */
public class ResponseErrorInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        okhttp3.Response response = null;
        POSApplication application = POSApplication.getInstance();
        try {
            response = chain.proceed(request);
        } catch (ConnectException  | SocketTimeoutException exception ) {
            exception.printStackTrace();
            if (application != null) {
                if (exception instanceof ConnectException)
                application
                        .getNetworkErrorBroadcaster()
                        .send(new NetworkError(NetworkError.FAILED_TO_CONNECT_WITH_SERVER, application.getString(R.string.failed_to_connect_server)));
                else application
                        .getNetworkErrorBroadcaster()
                        .send(new NetworkError(NetworkError.NETWORK_TIMEOUT, application.getString(R.string.server_request_timeout)));
            }
        }
        if (response == null) return chain.proceed(request);
        if (response.isSuccessful()) return response;
        else if (application != null) {
            int code;
            String message;
            // error case
            switch (response.code()) {
                case 404:
                    code = NetworkError.PAGE_NOT_FOUND;
                    message = application.getString(R.string.page_not_found);
                    break;
                case 500:
                    code = NetworkError.SERVER_FAILED;
                    message = application.getString(R.string.server_failed);
                    break;
                default:
                    code = NetworkError.UNKNOWN_ERROR;
                    message = application.getString(R.string.server_unknown_error);
                    break;
            }
            application
                    .getNetworkErrorBroadcaster()
                    .send(new NetworkError(code, message));
        }
        return chain.proceed(request);
    }
}