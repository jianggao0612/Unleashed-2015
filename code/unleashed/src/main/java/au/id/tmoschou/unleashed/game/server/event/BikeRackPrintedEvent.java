package au.id.tmoschou.unleashed.game.server.event;

import au.id.tmoschou.unleashed.game.server.domain.Location;

import java.util.ArrayList;

/**
 * Created by Gao on 4/07/15.
 */
public class BikeRackPrintedEvent {
    private ArrayList<Location> bikeRackLocations;

    public BikeRackPrintedEvent(ArrayList<Location> bikeRackLocations) {
        this.bikeRackLocations = bikeRackLocations;
    }

    public ArrayList<Location> getBikeRackLocations() {
        return bikeRackLocations;
    }

    public void setBikeRackLocations(ArrayList<Location> bikeRackLocations) {
        this.bikeRackLocations = bikeRackLocations;
    }
}
