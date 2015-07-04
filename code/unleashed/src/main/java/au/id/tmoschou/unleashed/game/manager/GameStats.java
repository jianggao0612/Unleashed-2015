package au.id.tmoschou.unleashed.game.manager;

import au.id.tmoschou.unleashed.game.location.MovementLocation;
import au.id.tmoschou.unleashed.game.location.PlayerLocation;
import au.id.tmoschou.unleashed.game.vehicle.IBike;
import au.id.tmoschou.unleashed.game.vehicle.ICar;

import org.springframework.stereotype.Component;

@Component
public class GameStats {

	public static double score = 100.0;

	public static MovementLocation currentLocation;

	public static double carbonEmission = 0.0;

	public static double moneySpent = 0.0;

	public static int comfortPercent = 50;

	public static double timeElapsed = 0.0;

	public static PlayerLocation player;

	public static IBike myBike;

	public static ICar myCar;

}
