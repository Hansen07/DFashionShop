package com.example.uas_mobileprogramming;

import android.content.Context;
import android.content.pm.PackageManager;
import org.osmdroid.config.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.osmdroid.events.MapEventsReceiver;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.MapEventsOverlay;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;

public class fragmentlokasiB extends Fragment implements MapEventsReceiver {
    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    private MapView map = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate (R.layout.fragment_location, container,false);


        Context ctx = getActivity();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        map = (MapView)view.findViewById(R.id.map);
        MapEventsOverlay mapEventsOverlay = new MapEventsOverlay(ctx,this);
        map.getOverlays().add(0,mapEventsOverlay);
        map.setTileSource(TileSourceFactory.MAPNIK);
        //perm check
        String[] permissionStrings = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};
        requestPermissionIfNeccessary(permissionStrings);

        map.getController().setZoom(20);
        GeoPoint B = new GeoPoint(-6.916319633556482,107.59370478791487);

        map.getController().setCenter(B);

        GeoPoint startpoint2 = new GeoPoint(-6.916319633556482,107.59370478791487);

        Marker startMarker =new Marker(map);
        startMarker.setPosition(startpoint2);
        startMarker.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);
        startMarker.setTitle("D'Fashion Shop\nOutlet B");
        map.getOverlays().add(startMarker);
        map.invalidate();


        return view;
    }
    private void requestPermissionIfNeccessary(String[] permissions){
        ArrayList<String> permissionToRequest = new ArrayList<>();
        for(String permission:permissions){
            if(ContextCompat.checkSelfPermission(getContext(),permission)!= PackageManager.PERMISSION_GRANTED){
                permissionToRequest.add(permission);

            }
        }
        if(permissionToRequest.size()>0){
            ActivityCompat.requestPermissions(getActivity(),permissionToRequest.toArray(new String[permissionToRequest.size()]),
                    REQUEST_PERMISSIONS_REQUEST_CODE
            );
        }
    }
    @Override
    public boolean singleTapConfirmedHelper(GeoPoint p) {
        return false;
    }

    @Override
    public boolean longPressHelper(GeoPoint p) {
        return false;
    }
}