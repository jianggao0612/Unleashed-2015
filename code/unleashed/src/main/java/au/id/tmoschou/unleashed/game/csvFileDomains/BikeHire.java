package au.id.tmoschou.unleashed.game.csvFileDomains;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "latitude", "longitude", "price"})
public class BikeHire {
    private String name;
    private Double latitude;
    private Double longitude;
    private Double price;

    public BikeHire(String name, Double latitude, Double longitude, Double price) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
