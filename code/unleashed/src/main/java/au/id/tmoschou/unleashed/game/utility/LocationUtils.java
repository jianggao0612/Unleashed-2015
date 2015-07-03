package au.id.tmoschou.unleashed.game.utility;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import au.id.tmoschou.unleashed.game.location.LocationEdge;
import au.id.tmoschou.unleashed.game.location.MovementLocation;
import au.id.tmoschou.unleashed.game.utility.GameMechanicUtils.Transport;

public class LocationUtils {
	
	public static ArrayList<MovementLocation> getNearestMovements(MovementLocation currentLocation) {
		return null;
		// TODO use query database to find locations
	}
	
	public static MovementLocation getNearestTransportLocation(MovementLocation currentLocation, Transport currentType, Transport desiredType) {
		// TODO
		// if(transportType.avaliableTransport() == desiredType)
		return null;
	}
	
	/**
	 * 
	 * @param edge
	 * @param frac Ratio between 0.0 and 1.0 of where player is along the path
	 * @param fromStart 
	 * @return
	 */
	public static Point2D.Double getPointAlongPath(LocationEdge edge, double frac, boolean fromStart) {
		Point2D.Double s = edge.getStartLocation().getVisualPoint();
		Point2D.Double e = edge.getEndLocation().getVisualPoint();
		
		// TODO this is using linear
		double x = fromStart ? s.x + frac * (e.x - s.x) : e.x + frac * (s.x - e.x);
		double y = fromStart ? s.y + frac * (e.y - s.y) : e.y + frac * (s.y - e.y);
		
		return new Point2D.Double(x, y);
	}
	
	public static Point2D.Double convertGeoPointToVisualPoint(Point2D.Double geoPoint) {
		Point2D.Double result = new Point2D.Double();
		// TODO
		return result;
	}
	
	public static Double convertGeoLengthToVisualLength(Double geoLength) {
		// TODO
		return geoLength;
	}
}
