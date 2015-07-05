package com.lordmayors.shftr;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 4/07/15.
 */
public class ShftrGame
{
    private LatLng playerLocation;

    private List<ShftrLocation> locations;

    public ShftrGame()
    {
        locations = new ArrayList();
    }

    public LatLng getPlayerLocation() {
        return playerLocation;
    }

    public List<ShftrLocation> getLocations() {
        return locations;
    }

    public void addLocation( ShftrLocation location )
    {
        locations.add( location );
    }

    public void setPlayerLocation(LatLng playerLocation) {
        this.playerLocation = playerLocation;
    }
}
