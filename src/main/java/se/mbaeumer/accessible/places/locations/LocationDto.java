package se.mbaeumer.accessible.places.locations;

import se.mbaeumer.accessible.places.integration.NearBySearchResponse;
import se.mbaeumer.accessible.places.users.AppUser;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LocationDto {
    private Integer id;
    private String businessStatus;

    private String name;

    private String formattedAddress;

    private String googleApiCode;

    private String latitude;

    private String longitude;

    private Timestamp created;

    private Timestamp lastUpdated;

    private AppUser user;

    private String accessibleEntrance;

    private String accessibleSeating;

    private String accessibleRestRoom;

    public LocationDto(Integer id, String businessStatus, String name, String formattedAddress, String googleApiCode,
                       String latitude, String longitude, Timestamp created, Timestamp lastUpdated,
                       String accessibleEntrance, String accessibleSeating, String accessibleRestRoom) {
        this.id = id;
        this.businessStatus = businessStatus;
        this.name = name;
        this.formattedAddress = formattedAddress;
        this.googleApiCode = googleApiCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.created = created;
        this.lastUpdated = lastUpdated;
        this.accessibleEntrance = accessibleEntrance;
        this.accessibleSeating = accessibleSeating;
        this.accessibleRestRoom = accessibleRestRoom;
    }

    public static LocationDto of(Location location){
        return new LocationDto(location.getId(), location.getBusinessStatus(), location.getName(), location.getFormattedAddress(),
                location.getGoogleApiCode(), location.getLatitude(), location.getLongitude(), location.getCreated(),
                location.getLastUpdated(), location.getAccessibleEntrance(), location.getAccessibleSeating(),
                location.getAccessibleRestRoom());
    }

    public static LocationDto of(NearBySearchResponse.Place place){
        return new LocationDto(-1, place.getBusinessStatus(), place.getDisplayName().getText(),
                place.getFormattedAddress(), place.getId(), Double.toString(place.getLocation().getLatitude()),
                Double.toString(place.getLocation().getLongitude()), Timestamp.valueOf(LocalDateTime.now()),
                Timestamp.valueOf(LocalDateTime.now()), place.getAccessibilityOptions().getWheelchairAccessibleEntrance(),
                place.getAccessibilityOptions().getWheelchairAccessibleSeating(), place.getAccessibilityOptions().getWheelchairAccessibleRestroom());

    }

    public Integer getId() {
        return id;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public String getName() {
        return name;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public String getGoogleApiCode() {
        return googleApiCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public AppUser getUser() {
        return user;
    }

    public String getAccessibleEntrance() {
        return accessibleEntrance;
    }

    public String getAccessibleSeating() {
        return accessibleSeating;
    }

    public String getAccessibleRestRoom() {
        return accessibleRestRoom;
    }
}
