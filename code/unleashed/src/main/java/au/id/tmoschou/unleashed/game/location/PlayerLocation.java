package au.id.tmoschou.unleashed.game.location;

import au.id.tmoschou.unleashed.game.manager.GameStats;

import java.awt.geom.Point2D;

public class PlayerLocation extends Location {

    public PlayerLocation() {
        super(null);
    }

    public enum Transport {
        WALK ("MAN"),
        CAR ("CAR"),
        BIKE ("BIKE"),
        PUBLIC ("BUS");

        private String str;

        Transport(String s) {
            str = s;
        }

        public String getIconType() {
            return str;
        }
    }

    private Transport transportType;

    public Transport getTransportType() {
        return transportType;
    }

    @Override
    public Point2D.Double getPoint() {
        return GameStats.currentLocation.getPoint();
    }
}
