package com.bazan.backend.shared.domain.abstractions;

public class Result<T> extends ResultBase {
    private final T value;

    private Result(T value, boolean isSuccess, Error error) {
        super(isSuccess, error);
        this.value = value;
    }

    public static <T> Result<T> success(T value) {
        return new Result<T>(value, true, null);
    }

    public static <T> Result<T> failure(Error error) {
        return new Result<T>(null, false, error);
    }

    public T getValue() {
        if (isSuccess())
            return value;
        throw new IllegalStateException("Cannot access value on a failure result");
    }

    public static <T> Result<T> fromValue(T value) {
        return value != null ? success(value) : failure(Error.NullValue);
    }
}
