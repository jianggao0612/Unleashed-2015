package au.id.tmoschou.unleashed.game.server.event;

/**
 * Created by Gao on 4/07/15.
 */
public class BikeRackPrintEvent {
    private double longitude;
    private double latitude;

    public BikeRackPrintEvent(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
