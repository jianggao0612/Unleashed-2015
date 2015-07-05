package com.lordmayors.shftr;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by andy on 4/07/15.
 */
public class ShftrLocation
{
    private String name;
    private LatLng latLng;
    private String description;
    private int icon;

    public ShftrLocation( String name , LatLng latLng , int icon )
    {
        this.name = name;
        this.latLng = latLng;
        this.icon = icon;
    }

    public ShftrLocation(int iconIndex, String name, LatLng latLng, String description)
    {
        this.latLng = latLng;
        this.description = description;
        icon = icons[ iconIndex ];
        this.name = name;
    }

    public static int[] icons =
    {
        R.drawable.icon_sculpture,
        R.drawable.icon_cafe,
        R.drawable.icon_buildings,
        R.drawable.icon_historic,
        R.drawable.icon_bench
    };

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public String getDescription() {
        return description;
    }
}
