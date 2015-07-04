package au.id.tmoschou.unleashed.game.utility;

import au.id.tmoschou.unleashed.game.location.GeoPoint;
import au.id.tmoschou.unleashed.game.location.Location;

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

    public static double getDistance(Location a, Location b) {
        double sq_x = Math.pow(Math.abs(a.getPoint().x - b.getPoint().x),2);
        double sq_y = Math.pow(Math.abs(a.getPoint().y - b.getPoint().y),2);
        return Math.sqrt(sq_x - sq_y);
    }

}
