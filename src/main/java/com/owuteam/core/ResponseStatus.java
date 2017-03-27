package com.owuteam.core;

public class ResponseStatus {
    private boolean success = false;

    public ResponseStatus() {

    }

    public ResponseStatus(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
