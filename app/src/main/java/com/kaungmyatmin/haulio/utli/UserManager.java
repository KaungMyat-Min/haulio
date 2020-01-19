package com.kaungmyatmin.haulio.utli;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

/*create by Kaung Myat Min on 07/05/2019*/
@Singleton
public class UserManager {


    private SharedPreferences prefs;

    @Inject
    public UserManager(SharedPreferences prefs) {
        this.prefs = prefs;
    }

}
