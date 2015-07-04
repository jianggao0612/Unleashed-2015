package au.id.tmoschou.unleashed.game.server.service;

import au.id.tmoschou.unleashed.game.location.PlayerLocation;
import au.id.tmoschou.unleashed.game.manager.GameStats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * A service providing identity search and verification.
 */
@RestController
public class GameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    private final GameStats gameState;

    @Autowired
    public GameService(
        final GameStats gameState
    ) {
        this.gameState = gameState;
    }



    @RequestMapping(name = "/update-pos", method = RequestMethod.POST, produces = {"application/json"})

    public String updatePosition(
        @RequestParam(value = "latitude", defaultValue = "1") final double latitude,
        @RequestParam(value = "longitude", defaultValue = "1") final double longitude
    ) {
        LOGGER.debug("Got position ({},{})", latitude, longitude);

        PlayerLocation location = gameState.player;
        //location.set(latitude, longitude);

        return "";
    }


}
