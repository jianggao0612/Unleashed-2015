package com.lordmayors.shftr;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by andy on 4/07/15.
 */
public class ShftrGameFactory
{

    public ShftrGame newGame() {
        ShftrGame game = new ShftrGame();

        game.setPlayerLocation(new LatLng(-34.9290, 138.6010));

        ArrayList<ShftrLocation> list = new ArrayList<>();

        list.add(new ShftrLocation(0, "Malls Balls", new LatLng(-34.922784747273674, 138.60330440104008), "How Cool?"));
        list.add(new ShftrLocation(1, "Artisan Cafe & Bakery", new LatLng(-34.923872248578235, 138.60782325267792), "Need Coffee... Zzz"));
        list.add(new ShftrLocation(2, "Bendigo Bank", new LatLng(-34.92406110287196, 138.60277969390154), "Get some cash out..."));
        list.add(new ShftrLocation(3, "Museum of Classical Archaeology", new LatLng(-34.92087993586752, 138.604527823627), "Archaelogical!!"));
        list.add(new ShftrLocation(4, "Botanic Gardens", new LatLng(-34.92055307029433, 138.61065935343504), "Take in some nature."));

        while( ! list.isEmpty() ) game.addLocation( list.remove((int)(Math.random()*list.size() ) ) );

        return game;
    }
}