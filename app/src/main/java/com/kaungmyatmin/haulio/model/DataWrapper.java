package com.kaungmyatmin.haulio.model;

import com.kaungmyatmin.haulio.errorhandler.ErrorType;

public class DataWrapper<T> {
    private T data;

    private ErrorType errorType;

    private boolean isLoading;

    public DataWrapper(T data,  ErrorType errorType, boolean isLoading) {
        this.data = data;

        this.errorType = errorType;
        this.isLoading = isLoading;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }
}
