package au.id.tmoschou.unleashed.game.utility;

import au.id.tmoschou.unleashed.game.csvFileDomains.*;
import au.id.tmoschou.unleashed.game.factory.LocationFactory;
import au.id.tmoschou.unleashed.game.location.GeoPoint;
import au.id.tmoschou.unleashed.game.location.ITransportLocation;
import au.id.tmoschou.unleashed.game.location.MovementLocation;
import au.id.tmoschou.unleashed.game.location.PlayerLocation.Transport;
import au.id.tmoschou.unleashed.game.location.SpecialLocation;
import au.id.tmoschou.unleashed.game.manager.GameStats;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 4/07/2015.
 */
public class GetUtils {

    public static SpecialLocation getRandomGoalLocation() {
        // TODO?
        int index = (int) Math.round(Math.min(Math.random()*getGoalLocations().size(),getGoalLocations().size()-1));
        return getGoalLocations().get(index);
    }

    private static List<SpecialLocation> goalLocations;

    public static List<SpecialLocation> getGoalLocations() {
        if(goalLocations == null) {
            goalLocations = new ArrayList<>();
            for(DrinkingFountains o : DataSetGenerator.getDrinkingFountains()) {
                goalLocations.add((SpecialLocation) LocationFactory.createMapLocation(o));
            }
        }

        return goalLocations;
    }

    private static List<ITransportLocation> transportLocations;

    public static List<ITransportLocation> getTransportLocations() {
        if(transportLocations == null) {
            transportLocations = new ArrayList<>();
            for(BikeHire o : DataSetGenerator.getBikeHire()) {
                transportLocations.add((ITransportLocation) LocationFactory.createMapLocation(o));
            }
            for(BikeRack o : DataSetGenerator.getBikeRake()) {
                transportLocations.add((ITransportLocation) LocationFactory.createMapLocation(o));
            }
            for(ParkingMachine o : DataSetGenerator.getParkingMachine()) {
                transportLocations.add((ITransportLocation) LocationFactory.createMapLocation(o));
            }
        }

        return transportLocations;
    }
}
