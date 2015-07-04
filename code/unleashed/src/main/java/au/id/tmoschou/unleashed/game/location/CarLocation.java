package au.id.tmoschou.unleashed.game.location;

import au.id.tmoschou.unleashed.game.location.PlayerLocation.Transport;

public class CarLocation extends MovementLocation implements ITransportLocation {

	public CarLocation(GeoPoint mapPoint) {
		super(mapPoint);
	}

	// TODO car types may not be used, the location might be difficult to look up from a dataset or database,
	// or at any road point a user can switch to car, which just gives negative points if you switch, as if it were a taxi
	public enum CarTypes {
		FREE_PARK,
		TICKET_PARK,
		TAXI,
		ROAD,
		CAR_DEALER;
	};
	
	@Override
	public Transport avaliableTransport(Transport currentTransport) {
		if(currentTransport == Transport.CAR) {
			return Transport.WALK;
		}
		return Transport.CAR;
	}

}
