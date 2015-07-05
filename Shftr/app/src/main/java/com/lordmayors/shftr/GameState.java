package com.lordmayors.shftr;

/**
 * Created by andy on 4/07/15.
 */
public class GameState
{
    private final ObservableDouble calories;
    private final ObservableDouble cash;
    private final ObservableDouble co2;
    private boolean bBusPaid = false;
    public double distance = 0.0;

    public GameState()
    {
        calories = new ObservableDouble( 0d );
        cash = new ObservableDouble( 100d );
        co2 = new ObservableDouble( 0d );
    }

    public ObservableDouble getCalories()
    {
        return calories;
    }

    public ObservableDouble getCash()
    {
        return cash;
    }

    public ObservableDouble getCo2()
    {
        return co2;
    }

    public boolean busPaid() {
        return bBusPaid;
    }

    public void setBusPaid( boolean b )
    {
        bBusPaid = b;
    }

    public double getTotal() {
        return getCalories().getValue() - getCash().getValue() - getCo2().getValue() * 100;
    }
}
