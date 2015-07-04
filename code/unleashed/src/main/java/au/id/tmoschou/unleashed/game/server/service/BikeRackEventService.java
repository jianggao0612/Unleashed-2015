package au.id.tmoschou.unleashed.game.server.service;

import au.id.tmoschou.unleashed.game.server.domain.Location;
import au.id.tmoschou.unleashed.game.server.event.BikeRackPrintEvent;
import au.id.tmoschou.unleashed.game.server.event.BikeRackPrintedEvent;

import java.util.ArrayList;

/**
 * Created by Gao on 4/07/15.
 */
public class BikeRackEventService {
    public BikeRackPrintedEvent printBikeRack (BikeRackPrintEvent bikeRackPrintEvent) {

        double longtitude = bikeRackPrintEvent.getLongitude();
        double latitude = bikeRackPrintEvent.getLatitude();

        DatabaseService dbService = new DatabaseService();
        ArrayList<Location> bikeRacks = dbService.getLocationByType("Back Rack");

        for(int i = 0; i < bikeRacks.size(); i++) {
            double destinationLongitude = bikeRacks.get(i).getLongitude();
            double destinationLatitude = bikeRacks.get(i).getLatitude();

            //TODO Calculate the distance between two points. If the distance is within the range, keep the point. Otherwise, delete.
        }

        return new BikeRackPrintedEvent(bikeRacks);
    }
}
