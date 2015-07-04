package au.id.tmoschou.unleashed.game.server.domain;

public class Location {
    private String objectType;
    private String name;
    private double longitude;
    private double latitude;
    private double altitude;
    private String address;
    private String postCode;
    private String imageUrl;
    private String websiteUrl;
    private int postiveScoreOne;
    private int positiveScoreTwo;
    private int negativeScoreOne;
    private int negativeScoreTwo;

    public Location(String objectType, String name, double longitude, double latitude, double altitude, String address, String postCode, String imageUrl, String websiteUrl, int postiveScoreOne, int positiveScoreTwo, int negativeScoreOne, int negativeScoreTwo) {
        this.objectType = objectType;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.address = address;
        this.postCode = postCode;
        this.imageUrl = imageUrl;
        this.websiteUrl = websiteUrl;
        this.postiveScoreOne = postiveScoreOne;
        this.positiveScoreTwo = positiveScoreTwo;
        this.negativeScoreOne = negativeScoreOne;
        this.negativeScoreTwo = negativeScoreTwo;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public int getPostiveScoreOne() {
        return postiveScoreOne;
    }

    public void setPostiveScoreOne(int postiveScoreOne) {
        this.postiveScoreOne = postiveScoreOne;
    }

    public int getPositiveScoreTwo() {
        return positiveScoreTwo;
    }

    public void setPositiveScoreTwo(int positiveScoreTwo) {
        this.positiveScoreTwo = positiveScoreTwo;
    }

    public int getNegativeScoreOne() {
        return negativeScoreOne;
    }

    public void setNegativeScoreOne(int negativeScoreOne) {
        this.negativeScoreOne = negativeScoreOne;
    }

    public int getNegativeScoreTwo() {
        return negativeScoreTwo;
    }

    public void setNegativeScoreTwo(int negativeScoreTwo) {
        this.negativeScoreTwo = negativeScoreTwo;
    }
}
