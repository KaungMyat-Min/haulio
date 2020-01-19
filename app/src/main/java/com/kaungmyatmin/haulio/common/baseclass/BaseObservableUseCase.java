package com.kaungmyatmin.haulio.common.baseclass;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.kaungmyatmin.haulio.errorhandler.ErrorType;
import com.kaungmyatmin.haulio.model.DataWrapper;

public class BaseObservableUseCase<T> {
    private MutableLiveData<DataWrapper<T>> result = new MutableLiveData<>();

    protected void postResult(T data, ErrorType errorType, boolean isLoading) {
        DataWrapper<T> dataWrapper = new DataWrapper<>(data, errorType, isLoading);
        this.result.postValue(dataWrapper);
    }

    protected void postResult(T data) {
        postResult(data, null, false);
    }

    protected void postError(ErrorType errorType) {
        postResult(null, errorType, false);
    }


    protected void postLoading(boolean isLoading) {
        DataWrapper<T> dataWrapper = new DataWrapper<>(null, null, isLoading);
        this.result.postValue(dataWrapper);
    }

    protected void setLoading(boolean isLoading) {
        DataWrapper<T> dataWrapper = new DataWrapper<>(null, null, isLoading);
        this.result.setValue(dataWrapper);
    }

    public LiveData<DataWrapper<T>> getResult() {
        return result;
    }
}
