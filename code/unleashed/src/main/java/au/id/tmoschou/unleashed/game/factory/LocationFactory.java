package au.id.tmoschou.unleashed.game.factory;

import au.id.tmoschou.unleashed.game.location.*;

import java.awt.geom.Point2D;
import java.util.Map;

public class LocationFactory {

	public static Location createMapLocation( Map<String, String> csvValues ) {
		// TODO
		// this will create a map object based on database parameters,
		// this method may query the database for the item,
		// BUT it is probably best for the row to just be the information from the database and what table it was from
		
		// the concept of the factory is you recieve a Location (or maybe MovementLocation, or SpecialLocation)
		// and you don't have to call constructors
		
		// a factory method can exist for creating a LocationEdge

		double lon = Double.parseDouble(csvValues.get("longitude"));
		double lat = Double.parseDouble(csvValues.get("latitude"));

		GeoPoint point = new GeoPoint(lon, lat);

		Location result;

		if(csvValues.get("type").equals("bike_rack")) {
			result = new BikeLocation(point);
		} else {
			result = new SpecialLocation(point);
		}

		return result;
	}

}
