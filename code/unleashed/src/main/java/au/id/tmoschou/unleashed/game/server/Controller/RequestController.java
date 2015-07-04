package au.id.tmoschou.unleashed.game.server.controller;

import au.id.tmoschou.unleashed.game.location.GeoPoint;
import au.id.tmoschou.unleashed.game.server.domain.Point;
import au.id.tmoschou.unleashed.game.server.event.BikeRackPrintEvent;
import au.id.tmoschou.unleashed.game.server.event.BikeRackPrintedEvent;
import au.id.tmoschou.unleashed.game.server.service.BikeRackEventService;
import au.id.tmoschou.unleashed.game.utility.GameMechanicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Gao on 4/07/15.
 */
@RestController
public class RequestController {

    private BikeRackEventService bikeRackEventService;

    @Autowired
    public RequestController(BikeRackEventService bikeRackEventService) {
        this.bikeRackEventService = bikeRackEventService;
    }

    @RequestMapping("/bikerack")
    public BikeRackPrintedEvent printBikeRack (
            @RequestParam(value = "longitude", required = true)  String longitude,
            @RequestParam(value = "latitude", required = true) String latitude
    ){
        double longitudeDouble = Double.parseDouble(longitude);
        double latitudeDouble = Double.parseDouble(latitude);

        BikeRackPrintEvent bikeRake = new BikeRackPrintEvent(longitudeDouble, latitudeDouble);

        return bikeRackEventService.printBikeRack(bikeRake);

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public GeoPoint printPoint (
            @RequestParam(value = "latitude", required = true) String latitude,
            @RequestParam(value = "longitude", required = true) String longitude
    ) {
        return new GeoPoint(Double.parseDouble(latitude), Double.parseDouble(longitude));
    }


}
