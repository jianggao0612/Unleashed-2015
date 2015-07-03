package au.id.tmoschou.unleashed.game.factory;

import au.id.tmoschou.unleashed.game.location.Location;

public class LocationFactory {

	public static Location createMapLocation(Object databaseParameters) {
		// TODO
		// this will create a map object based on database parameters,
		// this method may query the database for the item,
		// BUT it is probably best for the row to just be the information from the database and what table it was from
		
		// the concept of the factory is you recieve a Location (or maybe MovementLocation, or SpecialLocation)
		// and you don't have to call constructors
		
		// a factory method can exist for creating a LocationEdge
		
		return null;
	}
	
}
