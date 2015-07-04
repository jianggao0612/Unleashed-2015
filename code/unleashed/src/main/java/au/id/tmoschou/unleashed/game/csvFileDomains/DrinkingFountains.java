package au.id.tmoschou.unleashed.game.csvFileDomains;

/**
 * Created by Gao on 5/07/15.
 */
public class DrinkingFountains {
    private String name;
    private Double latitude;
    private Double longitude;

    public DrinkingFountains(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
