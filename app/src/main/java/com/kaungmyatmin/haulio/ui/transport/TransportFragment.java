package com.kaungmyatmin.haulio.ui.transport;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.common.baseclass.BaseFragment;
import com.kaungmyatmin.haulio.helper.AuthHelper;
import com.kaungmyatmin.haulio.helper.MyLog;
import com.kaungmyatmin.haulio.helper.PermissionHelper;
import com.kaungmyatmin.haulio.model.Job;
import com.kaungmyatmin.haulio.model.User;

import javax.inject.Inject;

public class TransportFragment extends BaseFragment implements OnMapReadyCallback {

    private static final String TAG = TransportFragment.class.getSimpleName();
    private static final int CURRENT_POSITION_TAG = 1;
    private static final int DESTINATION_TAG = 2;

    //-------- variables start ---------

    private Job job;
    private User user;
    private FusedLocationProviderClient locationProviderClient;

    //-------- variables start ---------


    //-------- view variables start ---------

    private TextView tvUserName, tvJobNumber;
    private ImageView ivProfilePic;
    private SupportMapFragment supportMapFragment;
    private GoogleMap googleMap;

    //-------- view variables end ---------


    @Inject
    TransportViewModel mViewModel;

    @Inject
    AuthHelper authHelper;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        if (args != null) {
            job = (Job) args.getSerializable("job");
        }
        View view = inflater.inflate(R.layout.fragment_transport, container, false);
        bindViews(view);
        updateTheme();
        locationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivityComponent().inject(this);
        setObservers();

        PermissionHelper.checkLocationPermission(this);

        supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.my_map);
        supportMapFragment.getMapAsync(TransportFragment.this);

        user = authHelper.getCurrentUser();

        tvUserName.setText(user.getName());
        tvJobNumber.setText(String.valueOf(job.getJobId()));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionHelper.REQUEST_LOCATION_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    MyLog.d(TAG, "permission granted");
                }
                break;
        }
    }

    @Override
    protected void bindViews(View view) {
        tvJobNumber = view.findViewById(R.id.tv_job_number);
        tvUserName = view.findViewById(R.id.tv_user_name);
        ivProfilePic = view.findViewById(R.id.img_profile);
    }

    @Override
    protected void updateTheme() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setObservers() {
        mViewModel.getCurrentLocation().observe(this, currentLocation -> {
            if (currentLocation != null) {
                updateMarker(currentLocation);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        mViewModel.fetchCurrentLocation(locationProviderClient);
        updateMarker(job);

    }

    private void updateMarker(Location currentLocation){
        LatLng latLng = new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_current_position))
                .title("Current Position");

        googleMap.addMarker(markerOptions);
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 2));
    }

    private void updateMarker(Job job){

        LatLng latLng = new LatLng(job.getGeolocation().getLatitude(),job.getGeolocation().getLongitude());

        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title("Job location");

        googleMap.addMarker(markerOptions);
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 2));
    }
}
