package se.mbaeumer.accessible.places.hotspots;

import se.mbaeumer.accessible.places.integration.TextSearchResponse;
import se.mbaeumer.accessible.places.users.AppUser;

public class HotSpotDto {
    private Integer id;
    private String name;
    private String address;
    private String googleApiCode;

    private String longitude;

    private String latitude;
    private AppUser user;

    private HotSpotDto(Integer id, String name, String address, String googleApiCode, String longitude, String latitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.googleApiCode = googleApiCode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public static HotSpotDto of(HotSpot hotSpot){
        return new HotSpotDto(hotSpot.getId(), hotSpot.getName(), hotSpot.getAddress(), hotSpot.getGoogleApiCode(), hotSpot.getLongitude(), hotSpot.getLatitude());
    }

    public static HotSpotDto of(TextSearchResponse.Place place){
        return new HotSpotDto(-1, place.getDisplayName().getText(), place.getFormattedAddress(),
                place.getId(), Double.toString(place.getLocation().getLongitude()),
                Double.toString(place.getLocation().getLatitude()));
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGoogleApiCode() {
        return googleApiCode;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
