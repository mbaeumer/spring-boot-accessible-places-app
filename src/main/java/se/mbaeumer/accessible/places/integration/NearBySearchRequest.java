package se.mbaeumer.accessible.places.integration;

public class NearBySearchRequest {
    private String longitude;

    private String latitude;

    private String radius;

    private int maxResults;

    private String[] includeTypes;

    public NearBySearchRequest(String longitude, String latitude, String radius, int maxResults, String[] includeTypes) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.radius = radius;
        this.maxResults = maxResults;
        this.includeTypes = includeTypes;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getRadius() {
        return radius;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public String[] getIncludeTypes() {
        return includeTypes;
    }
}
