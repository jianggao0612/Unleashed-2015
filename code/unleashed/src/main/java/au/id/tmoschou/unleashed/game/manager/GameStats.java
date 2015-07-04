package au.id.tmoschou.unleashed.game.manager;

import au.id.tmoschou.unleashed.game.location.GeoPoint;
import au.id.tmoschou.unleashed.game.location.MovementLocation;
import au.id.tmoschou.unleashed.game.location.PlayerLocation;
import au.id.tmoschou.unleashed.game.location.SpecialLocation;
import au.id.tmoschou.unleashed.game.vehicle.IBike;
import au.id.tmoschou.unleashed.game.vehicle.ICar;

import org.springframework.stereotype.Component;

@Component
public class GameStats {

	private static GameStats _gameStats = new GameStats();

	public static GameStats getInstance() {
		return _gameStats;
	}

	public double score = 100.0;

	public MovementLocation currentLocation;

	public double carbonEmission = 0.0;

	public double moneySpent = 0.0;

	public int comfortPercent = 50;

	public PlayerLocation player;

	public IBike myBike;

	public ICar myCar;

	public int numGoalsCompleted = 0;

	public SpecialLocation goalLocation;

}
