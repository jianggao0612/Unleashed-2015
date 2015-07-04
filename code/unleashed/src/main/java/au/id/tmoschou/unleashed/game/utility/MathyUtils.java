package au.id.tmoschou.unleashed.game.utility;

import au.id.tmoschou.unleashed.game.location.GeoPoint;

import java.awt.geom.Point2D;

/**
 * Created by Ben on 4/07/2015.
 */
public class MathyUtils {

    public static double getAngle(GeoPoint centre, GeoPoint other) {
        double deltaY = centre.y - other.y;
        double deltaX = centre.x - other.x;
        return Math.atan2(deltaY, deltaX) * 180 / Math.PI;
    }

}
