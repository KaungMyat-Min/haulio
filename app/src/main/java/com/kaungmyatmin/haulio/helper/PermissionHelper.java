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


public class PermissionHelper {
    public static final int REQUEST_STORAGE_PERMISSIONS_PROFILE_UPLOAD = 1;

    public static boolean checkStoragePermission(Context context) {
        return ActivityCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestStoragePermission(Activity context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PermissionHelper.neverAskAgainSelected(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                showSnackBar(context);
                return;
            }
        }

        ActivityCompat.requestPermissions(context,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_STORAGE_PERMISSIONS_PROFILE_UPLOAD);


    }

    public static void requestStoragePermission(Fragment fragment) {
        Activity context = fragment.getActivity();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PermissionHelper.neverAskAgainSelected(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                showSnackBar(context);
                return;
            }
        }

        fragment.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_STORAGE_PERMISSIONS_PROFILE_UPLOAD);
    }

    public static void setShouldShowStatus(Context context, String permission) {

        SharedPreferences genPrefs = context.getApplicationContext().getSharedPreferences("GENERIC_PREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = genPrefs.edit();
        editor.putBoolean(permission, true);
        editor.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private static boolean neverAskAgainSelected(Activity activity, String permission) {
        final boolean prevShouldShowStatus = getRatinaleDisplayStatus(activity, permission);
        final boolean currShouldShowStatus = ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
        return prevShouldShowStatus && !currShouldShowStatus;
    }


    private static boolean getRatinaleDisplayStatus(final Context context, final String permission) {
        SharedPreferences genPrefs = context.getApplicationContext().getSharedPreferences("GENERIC_PREFERENCES", Context.MODE_PRIVATE);
        return genPrefs.getBoolean(permission, false);
    }

    private static void showSnackBar(Activity activity) {
        View rootView = ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);

        Snackbar snackbar = Snackbar.make(rootView, R.string.permission_request_storage, Snackbar.LENGTH_LONG);


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
