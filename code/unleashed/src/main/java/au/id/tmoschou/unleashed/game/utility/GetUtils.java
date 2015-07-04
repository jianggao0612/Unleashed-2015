package au.id.tmoschou.unleashed.game.utility;

import au.id.tmoschou.unleashed.game.location.PlayerLocation.Transport;
import au.id.tmoschou.unleashed.game.manager.GameStats;

/**
 * Created by Ben on 4/07/2015.
 */
public class GetUtils {

    public static Transport getTransportType() {
        return GameStats.player.getTransportType();
    }
}
