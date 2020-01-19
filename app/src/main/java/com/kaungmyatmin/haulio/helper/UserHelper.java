package com.kaungmyatmin.haulio.helper;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

/*create by Kaung Myat Min on 07/05/2019*/
@Singleton
public class UserHelper {


    private SharedPreferences prefs;

    @Inject
    public UserHelper(SharedPreferences prefs) {
        this.prefs = prefs;
    }

}
