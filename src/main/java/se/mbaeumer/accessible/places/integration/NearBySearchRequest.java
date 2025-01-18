package se.mbaeumer.accessible.places.integration;

import se.mbaeumer.accessible.places.hotspots.HotSpotDto;

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

    public static NearBySearchRequest from(HotSpotDto hotSpotDto){
        NearBySearchRequest request = new NearBySearchRequest(hotSpotDto.getLongitude(), hotSpotDto.getLatitude(),
                "500", 20, new String[]{"restaurant"});
        return request;
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
