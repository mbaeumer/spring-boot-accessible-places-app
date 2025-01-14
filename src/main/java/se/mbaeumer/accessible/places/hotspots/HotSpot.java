package se.mbaeumer.accessible.places.hotspots;

import jakarta.persistence.*;
import se.mbaeumer.accessible.places.users.AppUser;

@Entity
@Table(name = "HotSpot")
public class HotSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String googleApiCode;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private AppUser user;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGoogleApiCode() {
        return googleApiCode;
    }

    public void setGoogleApiCode(String googleApiCode) {
        this.googleApiCode = googleApiCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public static HotSpot of(HotSpotDto hotSpotDto){
        HotSpot hotSpot = new HotSpot();
        hotSpot.setName(hotSpotDto.getName());
        hotSpot.setAddress(hotSpotDto.getAddress());
        hotSpot.setGoogleApiCode(hotSpotDto.getGoogleApiCode());
        hotSpot.setLongitude(hotSpotDto.getLongitude());
        hotSpot.setLatitude(hotSpotDto.getLatitude());
        return hotSpot;
    }
}
