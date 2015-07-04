package au.id.tmoschou.unleashed.game.vehicle;

/**
 * Created by Ben on 4/07/2015.
 */
public class Pajero implements ICar {


    @Override
    public double getEmission() {
        return 204.4;
    }

    @Override
    public double getCost() {
        return 1.24;
    }

    @Override
    public double getComfort() {
        return 5;
    }
}
