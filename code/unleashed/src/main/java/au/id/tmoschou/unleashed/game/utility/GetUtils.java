package au.id.tmoschou.unleashed.game.utility;

import au.id.tmoschou.unleashed.game.location.GeoPoint;
import au.id.tmoschou.unleashed.game.location.MovementLocation;
import au.id.tmoschou.unleashed.game.location.PlayerLocation.Transport;
import au.id.tmoschou.unleashed.game.location.SpecialLocation;
import au.id.tmoschou.unleashed.game.manager.GameStats;

/**
 * Created by Ben on 4/07/2015.
 */
public class GetUtils {

    public static SpecialLocation getRandomGoalLocation() {
        return new SpecialLocation(new GeoPoint(0.0,0.0));
    }
}
