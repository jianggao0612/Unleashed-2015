package au.id.tmoschou.unleashed.game.location;

import au.id.tmoschou.unleashed.game.utility.GameMechanicUtils.Transport;

public class PublicTransportLocation extends MovementLocation implements
		ITransportLocation {
	
	public enum PublicTransportTypes {
		BUS_STOP,
		TRAIN_STATION,
		TRAM_STOP,
		INTERCHANGE;
	};
	
	@Override
	public Transport avaliableTransport(Transport currentTransport) {
		if(currentTransport == Transport.PUBLIC) {
			return Transport.WALK;
		}
		return Transport.PUBLIC;
	}

}
