package com.kaungmyatmin.haulio.ui.login;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kaungmyatmin.haulio.common.baseclass.BaseViewModel;
import com.kaungmyatmin.haulio.model.User;

import javax.inject.Inject;

public class LoginViewModel extends BaseViewModel {

    public enum AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,          // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    private MutableLiveData<AuthenticationState> authenticationState;
    @Inject
    public LoginViewModel() {
        init();
    }

    @Override
    protected void init() {
        authenticationState = new MutableLiveData<>();
    }

    public void authenticate(User user) {
        //todo: implement authentication user at the backend
        //now we authenticate user with google
        authenticationState.setValue(AuthenticationState.AUTHENTICATED);
    }

    public void authenticateFail(){
        //todo: this method should be remove in later version, combine this method with authenticate(User user) method
        authenticationState.setValue(AuthenticationState.INVALID_AUTHENTICATION);
    }

    public void refuseAuthentication() {
        authenticationState.setValue(AuthenticationState.UNAUTHENTICATED);
    }

    //------- getter and setter -------
    public LiveData<AuthenticationState> getAuthenticationState() {
        return authenticationState;
    }
}
