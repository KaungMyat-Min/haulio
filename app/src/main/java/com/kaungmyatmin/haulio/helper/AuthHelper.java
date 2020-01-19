package com.kaungmyatmin.haulio.helper;

import android.content.SharedPreferences;

import com.kaungmyatmin.haulio.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/*create by Kaung Myat Min on 07/05/2019*/
@Singleton
public class AuthHelper {


    private SharedPreferences prefs;

    @Inject
    public AuthHelper(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public User getCurrentUser(){
        User user = new User();
        user.setId("test_id");
        user.setName("Test Name");
        user.setProfilePic("profilePic");
        return  user;
    }

}
