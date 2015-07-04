package au.id.tmoschou.unleashed.game.location;

import au.id.tmoschou.unleashed.game.location.PlayerLocation.Transport;

public class BikeLocation extends MovementLocation implements ITransportLocation {

	public BikeLocation(GeoPoint mapPoint) {
		super(mapPoint);
	}

	public enum BikeTypes {
		RACK,
		HIRE,
		SHOP;
	};
	
	@Override
	public Transport avaliableTransport(Transport currentTransport) {
		if(currentTransport == Transport.BIKE) {
			return Transport.WALK;
		}
		return Transport.BIKE;
	}

}
