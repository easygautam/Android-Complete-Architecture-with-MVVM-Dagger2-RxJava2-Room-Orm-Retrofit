package com.gautams.pos.network;

/**
 * User Name: gautams2
 * Create Date : 9/22/2018
 */
public class NetworkError {

    public static final int INTERNET_CONNECTION_ERROR = 100;
    public static final int PAGE_NOT_FOUND = 404;
    public static final int SERVER_FAILED = 500;
    public static final int UNKNOWN_ERROR = 50;
    public static final int NETWORK_TIMEOUT = 40;
    public static final int FAILED_TO_CONNECT_WITH_SERVER = 202;

    private int code;
    private String message;

    public NetworkError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
