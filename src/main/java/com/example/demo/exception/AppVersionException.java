package com.example.demo.exception;

public class AppVersionException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AppVersionException(String appVersion) {

        super(String.format("App Version is not valid: %s", appVersion));
    }

}
