package com.lordmayors.shftr;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;

/**
 * Created by andy on 4/07/15.
 */
public class CameraUpdateCallback implements GoogleMap.OnMapLoadedCallback {
    private final CameraUpdate cameraLocation;
    private GoogleMap map;

    public CameraUpdateCallback(CameraUpdate cameraLocation, GoogleMap map)
    {
        this.cameraLocation = cameraLocation;
        this.map = map;
    }



    @Override
    public void onMapLoaded()
    {
        map.animateCamera(cameraLocation, 5000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish()
            {

            }

            @Override
            public void onCancel()
            {

            }
        });
    }
}
