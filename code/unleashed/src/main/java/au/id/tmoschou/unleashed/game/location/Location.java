package au.id.tmoschou.unleashed.game.location;

public abstract class Location {

//	String name;
//	String type;
//	String urlIcon;

	private GeoPoint point;

	public Location(GeoPoint mapPoint) {
		this.point = mapPoint;
	}

	public GeoPoint getPoint() {
		return point;
	}
	
}
