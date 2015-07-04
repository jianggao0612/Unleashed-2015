package au.id.tmoschou.unleashed.game.utility;

import au.id.tmoschou.unleashed.game.location.GeoPoint;
import au.id.tmoschou.unleashed.game.location.LocationEdge;

import java.util.ArrayList;

public class LocationUtils {

	private static final double RADIUS_IN_METRES = 20;
	public static final double RADIUS = convertMetresToGeo(RADIUS_IN_METRES);
	public static final int NUM_POINTS = 12;

	/**
	 * 
	 * @param edge
	 * @param frac Ratio between 0.0 and 1.0 of where player is along the path
	 * @param fromStart 
	 * @return
	 */
	@Deprecated
	public static GeoPoint getPointAlongPath(LocationEdge edge, double frac, boolean fromStart) {
		GeoPoint s = edge.getStartLocation().getPoint();
		GeoPoint e = edge.getEndLocation().getPoint();
		
		// TODO this is using linear
		double x = fromStart ? s.x + frac * (e.x - s.x) : e.x + frac * (s.x - e.x);
		double y = fromStart ? s.y + frac * (e.y - s.y) : e.y + frac * (s.y - e.y);
		
		return new GeoPoint(x, y);
	}

	public static double convertGeoToMetres(double geoDistance) {
		// TODO
		return geoDistance;
	}

	public static double convertMetresToGeo(double metresDistance) {
		// TODO
		return metresDistance;
	}

	private static double[] _rx;
	private static double[] _ry;

	public static void setUpRadiusArrays() {
		_rx = new double[NUM_POINTS];
		_ry = new double[NUM_POINTS];

		for(int i = 0; i < NUM_POINTS; i++) {
			double angle = i*(360.0/NUM_POINTS);
			_rx[i] = RADIUS*Math.cos(angle);
			_ry[i] = RADIUS*Math.sin(angle);
		}
	}

	public static ArrayList<GeoPoint> getRadiusPoints(GeoPoint centre) {
		ArrayList<GeoPoint> result = new ArrayList<>();

		if(_ry == null || _rx == null) {
			setUpRadiusArrays();
		}

		for(int i = 0; i< NUM_POINTS; i++) {
			result.add(new GeoPoint(centre.x+_rx[i], centre.y+_ry[i]));
		}

		return result;
	}

	public static double getDistance(GeoPoint a, GeoPoint b) {
		double sq_x = Math.pow(Math.abs(a.x - b.x),2);
		double sq_y = Math.pow(Math.abs(a.y - b.y),2);
		return Math.sqrt(sq_x - sq_y);
	}

}
