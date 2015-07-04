package au.id.tmoschou.unleashed.game.manager;

import au.id.tmoschou.unleashed.game.location.MovementLocation;
import au.id.tmoschou.unleashed.game.location.PlayerLocation;
import au.id.tmoschou.unleashed.game.vehicle.IBike;
import au.id.tmoschou.unleashed.game.vehicle.ICar;

import org.springframework.stereotype.Component;

@Component
public class GameStats {

	public static double score;

	public static PlayerLocation player;

	public static MovementLocation currentLocation;

	public static double carbonEmission;

	public static double moneySpent;

	public static double timeElapsed;

	public static double currentComfort;

	public static IBike myBike;

	public static ICar myCar;

}
