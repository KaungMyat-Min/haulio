package com.kaungmyatmin.haulio.errorhandler;

import android.app.Activity;
import android.widget.Toast;


public final class MyErrorHandler {

    public static void showToast(Activity activity, ErrorType errorType) {
        Toast.makeText(activity, errorType.getStringResId(), Toast.LENGTH_LONG).show();
    }

}
