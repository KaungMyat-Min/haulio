package com.kaungmyatmin.haulio.ui.transport;

import android.location.Location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.kaungmyatmin.haulio.common.baseclass.BaseViewModel;

import javax.inject.Inject;

public class TransportViewModel extends BaseViewModel {

    private MutableLiveData<Location> currentLocation;

    @Inject
    public TransportViewModel() {

        init();
    }

    @Override
    protected void init() {
        currentLocation = new MutableLiveData<>();
    }

    public void fetchCurrentLocation(FusedLocationProviderClient locationProviderClient){
        Task<Location> task = locationProviderClient.getLastLocation();
        task.addOnSuccessListener(location -> {
            if (location != null) {
                currentLocation.postValue(location);
            }
        });

    }


    //----------- getter and setter -----------

    public LiveData<Location> getCurrentLocation(){
        return  this.currentLocation;
    }
}
