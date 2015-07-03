package au.id.tmoschou.unleashed.game.location;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public abstract class Location {
	
	protected Point2D.Double visualPoint;
	protected Point2D.Double geoPoint;
	
	
	public Double getVisualPoint() {
		return visualPoint;
	}
	
	public Double getGeoPoint() {
		return geoPoint;
	}
	
}
