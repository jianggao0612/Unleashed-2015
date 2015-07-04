package au.id.tmoschou.unleashed.game.engine;

import au.id.tmoschou.unleashed.game.location.PlayerLocation;

import org.springframework.stereotype.Component;

@Component
public class GameState {

    PlayerLocation playerLocation;

    public PlayerLocation getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(PlayerLocation playerLocation) {
        this.playerLocation = playerLocation;
    }
}
