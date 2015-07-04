package au.id.tmoschou.unleashed.game.utility;

import au.id.tmoschou.unleashed.game.factory.LocationFactory;
import au.id.tmoschou.unleashed.game.location.MovementLocation;
import au.id.tmoschou.unleashed.game.location.PlayerLocation.Transport;
import au.id.tmoschou.unleashed.game.manager.GameStats;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GameMechanicUtils {

	/** get current icon type */
	public static String getIconType() {
		return GameStats.player.getTransportType().getIconType();
	}

	/** get next point given the cursor point and aviable map points */
	public static Point2D.Double getNextPoint(Point2D.Double clickedPoint, ArrayList<Point2D.Double> mapPoints) {

		MovementLocation result = GameStats.currentLocation;

		ArrayList<MovementLocation> movementLocations = new ArrayList<>();

		for(Point2D.Double mapPoint : mapPoints) {
			movementLocations.add(new MovementLocation(mapPoint));
		}

		// TODO: query dataset to add bike racks and public transport stops to movementLocations

		if(movementLocations.size() < 1) {
			return result.getPoint();
		}

		double goalAngle = MathyUtils.getAngle(GameStats.currentLocation.getPoint(), clickedPoint);
		double minDiff = 360.0;

		for(MovementLocation movementLocation : movementLocations) {
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
