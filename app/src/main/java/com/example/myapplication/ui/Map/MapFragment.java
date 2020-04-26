package com.example.myapplication.ui.Map;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.Context.LOCATION_SERVICE;


public class MapFragment extends Fragment
       // implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener
        {

    private MapViewModel homeViewModel;

    private GoogleMap mMap;


//    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
//    private static final int ALL_PERMISSIONS_RESULT = 1011;
//
//    private static final long UPDATE_INTERVAL = 5000, FASTEST_INTERVAL = 5000; // = 5 seconds
//    private Button manual;
//    private MapView mMapView;
//    private MainActivity activity;
//    private GoogleMap googleMap;
//    private Location location;
//    private GoogleApiClient googleApiClient;
//    private LocationRequest locationRequest;
//    private boolean open = false;

    public View onCreateView (@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(MapViewModel.class);
        View root = inflater.inflate(R.layout.map, container, false);


//        activity = (MainActivity) getActivity();
//        mMapView = mMapView.findViewById(R.id.map);
//        mMapView.onCreate(savedInstanceState);
//        mMapView.onResume(); // needed to get the map to display immediately
//        mMapView.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(GoogleMap mMap) {
//                googleMap = mMap;
//
//                //TODO: maybe set a default location to SA
//            }
//        });
//        getActivity().setTitle("home page");//TODO
//        try {
//            MapsInitializer.initialize(activity.getApplicationContext());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
       // permision();





        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }



//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
//
//
//    @Override
//    public void onStatusChanged(String s, int i, Bundle bundle) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String s) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String s) {
//
//    }
//
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (googleApiClient != null) {
//            googleApiClient.connect();
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        mMapView.onResume();
//
//        if (!checkPlayServices()) {
//            // TODO: show alert dialog
//            Toast.makeText(activity, "You need to install Google Play Services to use the App properly", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        mMapView.onPause();
//
//        // stop location updates
//        if (googleApiClient != null && googleApiClient.isConnected()) {
//            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, (com.google.android.gms.location.LocationListener) this);
//            googleApiClient.disconnect();
//        }
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mMapView.onDestroy();
//    }
//
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        mMapView.onLowMemory();
//    }
//
//    private boolean checkPlayServices() {
//        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
//        int resultCode = apiAvailability.isGooglePlayServicesAvailable(activity);
//
//        if (resultCode != ConnectionResult.SUCCESS) {
//            if (apiAvailability.isUserResolvableError(resultCode)) {
//                apiAvailability.getErrorDialog(activity, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST);
//            } else {
//                activity.finish();
//            }
//
//            return false;
//        }
//
//        return true;
//    }
//
//    private void showLocation(Location location) {
//        if (location == null || googleMap == null) {
//            return;
//        }
//
//        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
//
//        // For zooming automatically to the location
//        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(17).build();
//        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//
//        googleMap.clear();
//        googleMap.addMarker(new MarkerOptions().position(latLng)
//                .title("You are here"));
//    }
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//        if (ActivityCompat.checkSelfPermission(activity,
//                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(activity,
//                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//
//        // Permissions ok, we get last location
//        location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient); // FIXME:
//
//        if (location != null) {
//            showLocation(location);
//        }
//        startLocationUpdates();
//    }
//
//    private void startLocationUpdates() {
//        locationRequest = new LocationRequest();
//        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        locationRequest.setInterval(UPDATE_INTERVAL);
//        locationRequest.setFastestInterval(FASTEST_INTERVAL);
//
//        if (ActivityCompat.checkSelfPermission(activity,
//                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(activity,
//                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            Toast.makeText(activity, "You need to enable permissions to display location !", Toast.LENGTH_SHORT).show();
//        }
//
//        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, (com.google.android.gms.location.LocationListener) this);
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//        if (location != null) {
//            showLocation(location);
//            //Toast.makeText(activity, "Latitude : " + location.getLatitude() + "\nLongitude : " + location.getLongitude(), Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        switch (requestCode) {
//            case 1:
//                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                    if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                        if (grantResults[2] == PackageManager.PERMISSION_GRANTED) {
//                            if (grantResults[3] == PackageManager.PERMISSION_GRANTED) {
//                                // TODO remove  it after testing
//                                //TODO shahd1
//                                Toast.makeText(getActivity(), "Welcome... after all Permissions granted", Toast.LENGTH_LONG).show();
//                            } else {
//                                closeNow();
//                            }
//                        } else {
//                            closeNow();
//                        }
//                    } else {
//                        closeNow();
//                    }
//                } else {
//                    closeNow();
//                }
//                break;
//        }
//    }
//
//    private void closeNow() {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            getActivity().finishAffinity();
//            open = true;
//        } else {
//            getActivity().finish();
//            open = true;
//        }
//    }
//
//    private void permision() {
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (ContextCompat.checkSelfPermission(getActivity(),
//                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
//                    ContextCompat.checkSelfPermission(getActivity(),
//                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                    || ContextCompat.checkSelfPermission(getActivity(),
//                    Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED ||
//                    ContextCompat.checkSelfPermission(getActivity(),
//                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
////                Toast.makeText(activity, R.string.permission, Toast.LENGTH_LONG).show();
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
//                    if (alertDialog != null && !open) {
//                        //then show your dialog..else not
//                        open = true;
//
//                    }
//                }
//
//            }
//        }
//    }
//

}
