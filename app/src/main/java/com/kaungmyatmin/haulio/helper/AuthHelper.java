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

    public User getCurrentUser() {
        String id = prefs.getString("user_id", null);
        String name = prefs.getString("user_name", null);
        String profilePic = prefs.getString("user_profile_pic", null);

        User user = null;

        if (id != null && name != null && profilePic != null) {
            user = new User();
            user.setId(id);
            user.setName(name);
            user.setProfilePic(profilePic);

        }

        return user;
    }

    public boolean attempt(User user) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("user_id", user.getId())
                .putString("user_name", user.getName())
                .putString("user_profile_pic", user.getProfilePic())
                .apply();
        return true;

    }

    public void logout(){
        prefs.edit().clear().commit();
    }

    public boolean isLogged() {
        return getCurrentUser() != null;
    }

}
