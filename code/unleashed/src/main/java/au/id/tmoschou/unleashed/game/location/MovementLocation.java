package au.id.tmoschou.unleashed.game.location;
/**
 * Location for the Player Location to move towards
 * @author Ben
 *
 */
public class MovementLocation extends Location {

    protected String iconType = "ROAD";

    public MovementLocation(GeoPoint mapPoint) {
        super(mapPoint);
    }

    public String getIconType() {
        return iconType;
    }
}
