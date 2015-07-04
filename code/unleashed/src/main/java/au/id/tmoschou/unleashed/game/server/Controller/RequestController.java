package au.id.tmoschou.unleashed.game.server.controller;

import au.id.tmoschou.unleashed.game.server.event.BikeRackPrintEvent;
import au.id.tmoschou.unleashed.game.server.event.BikeRackPrintedEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gao on 4/07/15.
 */

@RestController
public class RequestController {
    @RequestMapping("/bikerack")
    public BikeRackPrintedEvent printBikeRack (
            @RequestParam(value = "longitude", required = true)  String longitude,
            @RequestParam(value = "latitude", required = true) String latitude
    ){
        double longitudeDouble = Double.parseDouble(longitude);
        double latitudeDouble = Double.parseDouble(latitude);

        BikeRackPrintEvent bikeRike = new BikeRackPrintEvent(longitudeDouble, latitudeDouble);
    }



}
