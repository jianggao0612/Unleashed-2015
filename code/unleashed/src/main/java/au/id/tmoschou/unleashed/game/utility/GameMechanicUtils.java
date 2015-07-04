package au.id.tmoschou.unleashed.game.utility;

import au.id.tmoschou.unleashed.game.location.GeoPoint;
import au.id.tmoschou.unleashed.game.location.ITransportLocation;
import au.id.tmoschou.unleashed.game.location.MovementLocation;
import au.id.tmoschou.unleashed.game.location.PlayerLocation;
import au.id.tmoschou.unleashed.game.location.PlayerLocation.Transport;
import au.id.tmoschou.unleashed.game.manager.GameStats;

import java.util.ArrayList;
import java.util.List;

public class GameMechanicUtils {

	/** test method */
	public static String testMethod() {
		return "Hello, this is a demo method. Well done!";
	}

	/** call this once */
	public static void initialiseGameVariables() {
		LocationUtils.setUpRadiusArrays();
		GameStats.getInstance().score = 0.0;
		GameStats.getInstance().player = new PlayerLocation();
		GameStats.getInstance().currentLocation = new MovementLocation(new GeoPoint(-34.92866, 138.59863));
		GameStats.getInstance().goalLocation = GetUtils.getRandomGoalLocation();
	}

	/** get current icon type */
	public static String getIconType() {
		return GameStats.getInstance().player.getTransportType().getIconType();
	}

	/** get next point given the cursor point and aviable map points */
	public static GeoPoint userLocationUpdate(GeoPoint clickedPoint, List<GeoPoint> mapPoints) {

		MovementLocation result = GameStats.getInstance().currentLocation;

		ArrayList<MovementLocation> movementLocations = new ArrayList<>();

		for(GeoPoint mapPoint : mapPoints) {
			movementLocations.add(new MovementLocation(mapPoint));
		}

		// TODO: query dataset to add bike racks and public transport stops to movementLocations
		// This is where Gao's locations loaded by CSV are used
		movementLocations.add(GameStats.getInstance().goalLocation);

		if(movementLocations.size() < 1) {
			return result.getPoint();
		}

		double goalAngle = MathyUtils.getAngle(GameStats.getInstance().currentLocation.getPoint(), clickedPoint);
		double minDiff = 360.0;

		for(MovementLocation movementLocation : movementLocations) {
			if(MathyUtils.getDistance(movementLocation, GameStats.getInstance().currentLocation) > LocationUtils.RADIUS ) {
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

		adjustStats(GameStats.getInstance().currentLocation, result);

		GameStats.getInstance().currentLocation = result;

		// YOU MADE IT TO THE GOAL!!! WELL DONE ! TWEEDLE DEE ME MATEY
		if(result == GameStats.getInstance().goalLocation) {
			GameStats.getInstance().numGoalsCompleted++;
			GameStats.getInstance().score += 100;
			GameStats.getInstance().goalLocation = GetUtils.getRandomGoalLocation();
		}

		return result.getPoint();
	}

	// user uses action button
	public static void userAction() {

		MovementLocation loc = GameStats.getInstance().currentLocation;
		PlayerLocation p = GameStats.getInstance().player;
		Transport tt = p.getTransportType();

		if(loc instanceof ITransportLocation) {
			p.setTransportType( ( (ITransportLocation) loc).avaliableTransport(tt));
		}

		adjustStats(tt, p.getTransportType(), loc);

	}

	public static ArrayList<GeoPoint> getMovementRadius() {
		return LocationUtils.getRadiusPoints(GameStats.getInstance().currentLocation.getPoint());
	}

	// returns the map points such as bike racks, goal point
	public static ArrayList<MovementLocation> getGeneralMapPoints() {
		ArrayList<MovementLocation> result = new ArrayList<>();
		result.add(GameStats.getInstance().goalLocation);
		return result;
	}

	private static void adjustStats(MovementLocation from, MovementLocation to) {
		// TODO: adjust stats for moving along a path

		double km = 0.001*LocationUtils.convertGeoToMetres(MathyUtils.getDistance(from, to));

		double carbon = 0;
		double cost = 0;

		switch(GameStats.getInstance().player.getTransportType()) {
			case BIKE:
				cost = GameStats.getInstance().myBike.getCost();
				GameStats.getInstance().comfortPercent += GameStats.getInstance().myBike.getComfort();
				break;
			case CAR:
				cost = GameStats.getInstance().myCar.getCost();
				carbon = GameStats.getInstance().myCar.getEmission()*km;
				GameStats.getInstance().comfortPercent += GameStats.getInstance().myCar.getComfort();
				break;
			case WALK:
				GameStats.getInstance().comfortPercent += -2;
		}

		// bounding comfort between 0 and 100
		GameStats.getInstance().comfortPercent = Math.max(GameStats.getInstance().comfortPercent, 0);
		GameStats.getInstance().comfortPercent = Math.min(GameStats.getInstance().comfortPercent, 100);

		GameStats.getInstance().carbonEmission -= carbon;
		GameStats.getInstance().moneySpent -= cost;

		GameStats.getInstance().score -= carbon;
		GameStats.getInstance().score -= cost;
		GameStats.getInstance().score += GameStats.getInstance().comfortPercent-50;

		// road speed
		// time elapse
	}

	private static void adjustStats(Transport from, Transport to, MovementLocation at) {

		if(from == to) {
			return;
		}

		// TODO: adjust stats for changing transport type

		// cost of parking or transport
	}

	
}
