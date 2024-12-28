package se.mbaeumer.accessible.places.hotspots;

import se.mbaeumer.accessible.places.users.AppUser;

public class HotSpotDto {
    private Integer id;
    private String name;
    private String address;
    private String googleApiCode;
    private AppUser user;

    private HotSpotDto(Integer id, String name, String address, String googleApiCode) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.googleApiCode = googleApiCode;
    }

    public static HotSpotDto of(HotSpot hotSpot){
        return new HotSpotDto(hotSpot.getId(), hotSpot.getName(), hotSpot.getAddress(), hotSpot.getGoogleApiCode());
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
}
