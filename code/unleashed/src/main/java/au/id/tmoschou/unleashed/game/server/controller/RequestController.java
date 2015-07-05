package au.id.tmoschou.unleashed.game.server.controller;

import au.id.tmoschou.unleashed.game.csvFileDomains.BikeRack;
import au.id.tmoschou.unleashed.game.csvFileDomains.DataSetGenerator;
import au.id.tmoschou.unleashed.game.location.GeoPoint;
import au.id.tmoschou.unleashed.game.manager.GameStats;
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
import java.util.List;

/**
 * Created by Gao on 4/07/15.
 */
@RestController
public class RequestController {

    @RequestMapping(value = "/bikerack", method = RequestMethod.GET)
    public List<BikeRack> printBikeRack (){

        return DataSetGenerator.getBikeRake();

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public GeoPoint printPoint (
            @RequestParam(value = "latitude", required = true) String latitude,
            @RequestParam(value = "longitude", required = true) String longitude
    ) {
        return new GeoPoint(Double.parseDouble(latitude), Double.parseDouble(longitude));
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public GameStats getGameStats(){
        return GameStats.getInstance();
    }


}
