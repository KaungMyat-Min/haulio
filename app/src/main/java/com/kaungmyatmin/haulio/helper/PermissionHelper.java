package com.kaungmyatmin.haulio.helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.kaungmyatmin.haulio.R;

import javax.inject.Inject;


public class PermissionHelper {
    public static final int REQUEST_LOCATION_PERMISSION = 101;


    public static boolean checkLocationPermission(Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (!isPermissionGranted(activity, Manifest.permission.ACCESS_FINE_LOCATION)
                && !isPermissionGranted(activity, Manifest.permission.ACCESS_COARSE_LOCATION)) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                //show user the explanation why we need the permission,
                showSnackBar(activity, R.string.permission_request_location);
            }

//            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
            fragment.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_LOCATION_PERMISSION);
//            fragment.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                    REQUEST_STORAGE_PERMISSIONS_PROFILE_UPLOAD);
//
            return false;
        } else {
            return true;
        }
    }

    private static boolean isPermissionGranted(Context context, String permission) {
        return ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    private static void showSnackBar(Activity activity, int resId) {
        View rootView = ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);

        Snackbar snackbar = Snackbar.make(rootView, resId, Snackbar.LENGTH_LONG);


        snackbar.setAction("Setting", view -> goToSetting(activity));

        snackbar.show();
    }

    private static void goToSetting(Activity activity) {
        Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + activity.getPackageName()));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        activity.startActivity(i);
    }
}
