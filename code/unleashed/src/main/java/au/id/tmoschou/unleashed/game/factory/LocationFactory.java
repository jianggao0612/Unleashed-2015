package au.id.tmoschou.unleashed.game.factory;

import au.id.tmoschou.unleashed.game.csvFileDomains.BikeHire;
import au.id.tmoschou.unleashed.game.csvFileDomains.BikeRack;
import au.id.tmoschou.unleashed.game.csvFileDomains.DrinkingFountains;
import au.id.tmoschou.unleashed.game.csvFileDomains.ParkingMachine;
import au.id.tmoschou.unleashed.game.location.*;
import au.id.tmoschou.unleashed.game.location.BikeLocation.BikeTypes;

import java.awt.geom.Point2D;
import java.util.Map;

public class LocationFactory {

	public static Location createMapLocation( Object o ) {
		// TODO
		// this will create a map object based on database parameters,
		// this method may query the database for the item,
		// BUT it is probably best for the row to just be the information from the database and what table it was from
		
		// the concept of the factory is you recieve a Location (or maybe MovementLocation, or SpecialLocation)
		// and you don't have to call constructors
		
		// a factory method can exist for creating a LocationEdge

		if(o instanceof BikeHire) {
			BikeHire bh = (BikeHire) o;
			BikeLocation bl = new BikeLocation(new GeoPoint(bh.getLongitude(), bh.getLatitude()));
			bl.type = BikeTypes.HIRE;
			return bl;
		}

		if(o instanceof BikeRack) {
			BikeRack br = (BikeRack) o;
			BikeLocation bl = new BikeLocation(new GeoPoint(br.getLongitude(), br.getLatitude()));
			bl.type = BikeTypes.RACK;
			return bl;
		}

		if(o instanceof BikeHire) {
			BikeHire bh = (BikeHire) o;
			BikeLocation bl = new BikeLocation(new GeoPoint(bh.getLongitude(), bh.getLatitude()));
			bl.type = BikeTypes.HIRE;
			return bl;
		}

		if(o instanceof BikeHire) {
			BikeHire bh = (BikeHire) o;
			BikeLocation bl = new BikeLocation(new GeoPoint(bh.getLongitude(), bh.getLatitude()));
			bl.type = BikeTypes.HIRE;
			return bl;
		}

		if(o instanceof ParkingMachine) {
			ParkingMachine pm = (ParkingMachine) o;
			CarLocation cl = new CarLocation(new GeoPoint(pm.getLongitude(), pm.getLatitude()));
			return cl;
		}
		if(o instanceof DrinkingFountains) {
			DrinkingFountains df = (DrinkingFountains) o;
			SpecialLocation sl = new SpecialLocation(new GeoPoint(df.getLongitude(), df.getLatitude()), "FOUNTAIN");
			return sl;
		}

		return null;
	}

}
