package com.lordmayors.shftr;

import android.view.animation.Interpolator;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by andy on 5/07/15.
 */
public class LatLngInterpolator
{
    public LatLng interpolate(float fraction, LatLng a, LatLng b)
    {
        return new LatLng( b.latitude * fraction + (1-fraction)*a.latitude , b.longitude * fraction + (1-fraction)*a.longitude );
    }
}
