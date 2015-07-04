package au.id.tmoschou.unleashed.game.vehicle;

/**
 * Created by Ben on 4/07/2015.
 */
public class CheapBike implements IBike {
    @Override
    public double getCost() {
        return 0.01;
    }

    @Override
    public double getComfort() {
        return -1;
    }
}
