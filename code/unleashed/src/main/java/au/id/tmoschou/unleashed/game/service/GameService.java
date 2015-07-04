package au.id.tmoschou.unleashed.game.service;



import com.google.common.base.Joiner;

import au.id.tmoschou.unleashed.game.engine.GameState;
import au.id.tmoschou.unleashed.game.location.PlayerLocation;

import com.damnhandy.uri.template.UriTemplate;
import com.wordnik.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.URI;


/**
 * A service providing identity search and verification.
 */
@RestController
public class GameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    private final Config config;
    private final GameState gameState;

    @Autowired
    public GameService(
        final Config config,
        final GameState gameState
    ) {
        this.config = config;
        this.gameState = gameState;
    }



    @RequestMapping(name = "/update-pos", method = RequestMethod.POST, produces = {"application/json"})

    public String updatePosition(
        @RequestParam(value = "latitude", defaultValue = "1") final double latitude,
        @RequestParam(value = "longitude", defaultValue = "1") final double longitude
    ) {
        LOGGER.debug("Got position ({},{})", latitude, longitude);
        
        PlayerLocation location = gameState.getPlayerLocation();
        //location.set(latitude, longitude);

        return "";
    }


}
