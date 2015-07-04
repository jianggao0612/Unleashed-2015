package au.id.tmoschou.unleashed.game.utility;

import java.awt.geom.Point2D;

/**
 * Created by Ben on 4/07/2015.
 */
public class MathyUtils {

    public static double getAngle(Point2D.Double centre, Point2D.Double other) {
        double deltaY = centre.y - other.y;
        double deltaX = centre.x - other.x;
        return Math.atan2(deltaY, deltaX) * 180 / Math.PI;
    }

}
