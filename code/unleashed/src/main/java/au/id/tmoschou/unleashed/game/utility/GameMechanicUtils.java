package au.id.tmoschou.unleashed.game.utility;

import au.id.tmoschou.unleashed.game.location.GeoPoint;
import au.id.tmoschou.unleashed.game.location.MovementLocation;
import au.id.tmoschou.unleashed.game.location.PlayerLocation.Transport;
import au.id.tmoschou.unleashed.game.manager.GameStats;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GameMechanicUtils {

	/** test method */
	public static String testMethod() {
		return "Hello, this is a demo method. Well done!";
	}

	/** call this once */
	public static void initialiseGameVariables() {
		LocationUtils.setUpRadiusArrays();
		GameStats.score = 0.0;
		GameStats.currentLocation = new MovementLocation(new GeoPoint(0.0, 0.0));
	}

	/** get current icon type */
	public static String getIconType() {
		return GameStats.player.getTransportType().getIconType();
	}

	/** get next point given the cursor point and aviable map points */
	public static GeoPoint getNextPoint(GeoPoint clickedPoint, ArrayList<GeoPoint> mapPoints) {

		MovementLocation result = GameStats.currentLocation;

		ArrayList<MovementLocation> movementLocations = new ArrayList<>();

		for(GeoPoint mapPoint : mapPoints) {
			movementLocations.add(new MovementLocation(mapPoint));
		}

		// TODO: query dataset to add bike racks and public transport stops to movementLocations

		if(movementLocations.size() < 1) {
			return result.getPoint();
		}

		double goalAngle = MathyUtils.getAngle(GameStats.currentLocation.getPoint(), clickedPoint);
		double minDiff = 360.0;

		for(MovementLocation movementLocation : movementLocations) {
			if(LocationUtils.getDistance(movementLocation.getPoint(), GameStats.currentLocation.getPoint()) > LocationUtils.RADIUS ) {
				continue;
			}
			Double tempAngle = MathyUtils.getAngle(clickedPoint, movementLocation.getPoint());
			double diff = Math.abs(tempAngle - goalAngle);
			if(diff > 180) diff = 360 - diff;

			if(diff < minDiff) {
				minDiff = diff;
				result = movementLocation;
			}
		}

		adjustStats(GameStats.currentLocation, result);

		GameStats.currentLocation = result;

		return result.getPoint();
	}

	public static ArrayList<GeoPoint> getMovementRadius() {
		return LocationUtils.getRadiusPoints(GameStats.currentLocation.getPoint());
	}

	private static void adjustStats(MovementLocation from, MovementLocation to) {
		// TODO: adjust stats for moving along a path

		// reward scores
		// road speed
		// time elapse
	}

	private static void adjustStats(Transport from, Transport to, MovementLocation at) {
		// TODO: adjust stats for changing transport type

		// cost of parking or transport
	}

	
}
