package au.id.tmoschou.unleashed.game.location;

public class LocationEdge {

	private final MovementLocation start;
	private final MovementLocation end;
	
	private final PathType pathType;
	
	public enum PathType {
		COMMON_ROAD, // walking, bikes, cars
		ROAD_WITH_BIKE_LANE, // walking, bikes, cars (bonus points for bike)
		CAR_ONLY_ROAD, // cars (bonus points for car)
		BIKE_ROUTE, //walking, bikes (bonus points for bike)
		RAILWAY; //public transport only (inclusive of O'Barn?)
	}
	
	public LocationEdge(MovementLocation start, MovementLocation end, PathType pathType) {
		this.start = start;
		this.end = end;
		this.pathType = pathType;
	}
	
	public MovementLocation getStartLocation() {
		return start;
	}
	
	public MovementLocation getEndLocation() {
		return end;
	}
	
	public boolean isDrivingAllowed() {
		switch(pathType) {
		case COMMON_ROAD:
		case ROAD_WITH_BIKE_LANE:
		case CAR_ONLY_ROAD:
			return true;
		default:
			return false;
		}
	}
	
	public boolean isRidingAllowed() {
		switch(pathType) {
		case COMMON_ROAD:
		case ROAD_WITH_BIKE_LANE:
		case BIKE_ROUTE:
			return true;
		default:
			return false;
		}
	}
	
	public boolean isPublicTransportAllowed() {
		switch(pathType) {
		case COMMON_ROAD:
		case ROAD_WITH_BIKE_LANE:
		case CAR_ONLY_ROAD:
		case RAILWAY:
			return true;
		default:
			return false;
		}
	}
	
	public boolean isWalkingAllowed() {
		switch(pathType) {
		case COMMON_ROAD:
		case ROAD_WITH_BIKE_LANE:
		case BIKE_ROUTE:
			return true;
		default:
			return false;
		}
	}
	
}
