package au.id.tmoschou.unleashed.game.location;

import au.id.tmoschou.unleashed.game.utility.GameMechanicUtils.Transport;

/**
 * Interface for a location where a player can switch transport type
 * 
 * At these points the player should easily switch transport type by (e.g.) pressing the SPACE bar, or with a double click
 * 
 */

public interface ITransportLocation {
	
	/**
	 * Call this method to receive the changeable transport type
	 * 
	 * e.g. if it is a bike rack:
	 * availableTransport(WALK) returns BIKE
	 * availableTransport(BIKE) returns WALK
	 * 
	 */
	public Transport avaliableTransport(Transport currentTransport);
	
}
