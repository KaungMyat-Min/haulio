package com.kaungmyatmin.haulio.helper;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.kaungmyatmin.haulio.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Handle user data and authentication management
 *
 * Note: This class will mark as SINGLETON, never cache context within this class
 */
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

    public boolean save(User user) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("user_id", user.getId())
                .putString("user_name", user.getName())
                .putString("user_profile_pic", user.getProfilePic())
                .apply();
        return true;

    }


    public void logout(Activity activity){

        getGoogleSignInClient(activity)
                .signOut()
                .addOnCompleteListener(activity,task -> {
                   loggedOut();
                });

    }

    public boolean isLogged() {
        return getCurrentUser()!=null;
    }

    public GoogleSignInClient getGoogleSignInClient(Activity activity){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("592059006628-1gnlkov31ol5bah52n460ml5espm6gu1.apps.googleusercontent.com")
                .requestEmail()
                .build();

        return  GoogleSignIn.getClient(activity, gso);
    }

    private void loggedOut(){
        //todo: do necessary things after user logged out
        prefs.edit().clear().apply();
    }
}
