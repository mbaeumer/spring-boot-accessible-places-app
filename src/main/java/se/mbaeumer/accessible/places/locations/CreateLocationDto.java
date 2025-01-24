package se.mbaeumer.accessible.places.locations;

public class CreateLocationDto {
    private String hotspotId;
    private String name;
    private String accessibleEntrance;
    private String accessibleRestRoom;
    private String accessibleSeating;
    private String formattedAddress;
    private String googleApiCode;

    public String getHotspotId() {
        return hotspotId;
    }

    public void setHotspotId(String hotspotId) {
        this.hotspotId = hotspotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessibleEntrance() {
        return accessibleEntrance;
    }

    public void setAccessibleEntrance(String accessibleEntrance) {
        this.accessibleEntrance = accessibleEntrance;
    }

    public String getAccessibleRestRoom() {
        return accessibleRestRoom;
    }

    public void setAccessibleRestRoom(String accessibleRestRoom) {
        this.accessibleRestRoom = accessibleRestRoom;
    }

    public String getAccessibleSeating() {
        return accessibleSeating;
    }

    public void setAccessibleSeating(String accessibleSeating) {
        this.accessibleSeating = accessibleSeating;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getGoogleApiCode() {
        return googleApiCode;
    }

    public void setGoogleApiCode(String googleApiCode) {
        this.googleApiCode = googleApiCode;
    }
}
