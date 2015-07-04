package au.id.tmoschou.unleashed.game.location;

/**
 * Location relating to goals, special pass by bonuses
 * i.e. not a movement location, but it can be over the top of a movement location, or along a location edge
 * 
 * @author Ben
 *
 */
public class SpecialLocation extends MovementLocation {

    public SpecialLocation(GeoPoint mapPoint, String iconType) {
        super(mapPoint);
        this.iconType = iconType;
    }

}
