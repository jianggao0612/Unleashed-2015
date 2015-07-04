package au.id.tmoschou.unleashed.game.location;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public abstract class Location {

	private Point2D.Double point;

	public Location(Double mapPoint) {
		this.point = mapPoint;
	}
	
	public Double getPoint() {
		return point;
	}
	
}
