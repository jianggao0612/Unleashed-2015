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

    private Transport transportType = Transport.WALK;

    public Transport getTransportType() {
        return transportType;
    }
    public void setTransportType(Transport transportType) {
        this.transportType = transportType;
    }

    @Override
    public GeoPoint getPoint() {
        return GameStats.getInstance().currentLocation.getPoint();
    }
}
