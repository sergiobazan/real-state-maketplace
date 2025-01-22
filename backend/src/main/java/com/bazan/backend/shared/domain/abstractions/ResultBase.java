package com.bazan.backend.shared.domain.abstractions;

public class ResultBase {
    private final boolean isSuccess;
    private final Error error;

    protected ResultBase(boolean isSuccess, Error error) {
        if (isSuccess && error != null) {
            throw new IllegalArgumentException("Invalid error");
        }
        if (!isSuccess && error == null) {
            throw new IllegalArgumentException("Error is required for failure");
        }
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFailure() {
        return !isSuccess;
    }

    public Error error() {
        return error;
    }
}

