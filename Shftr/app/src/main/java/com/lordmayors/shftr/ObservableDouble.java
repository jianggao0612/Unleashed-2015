package com.lordmayors.shftr;

import java.util.Observable;

/**
 * Created by andy on 4/07/15.
 */
public class ObservableDouble extends Observable
{
    private double value;

    public ObservableDouble( double d )
    {
        value = d;
    }

    public void increment( double d )
    {
        setValue( value + d );
    }

    public double getValue()
    {
        return value;
    }

    public void setValue( double d )
    {
        value = d;
        setChanged();
        notifyObservers();
    }
}
