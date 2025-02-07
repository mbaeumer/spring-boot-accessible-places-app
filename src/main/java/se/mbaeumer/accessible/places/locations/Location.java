package se.mbaeumer.accessible.places.locations;

import jakarta.persistence.*;
import se.mbaeumer.accessible.places.hotspots.HotSpot;
import se.mbaeumer.accessible.places.users.AppUser;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String businessStatus;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String formattedAddress;

    @Column(nullable = false)
    private String googleApiCode;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotspotId")
    private HotSpot hotSpot;

    @Column(nullable = false)
    private Timestamp created;

    @Column(nullable = false)
    private Timestamp lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private AppUser user;

    @Column(nullable = false)
    private String accessibleEntrance;

    @Column(nullable = false)
    private String accessibleSeating;

    @Column(nullable = false)
    private String accessibleRestRoom;

    // Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public String getAccessibleEntrance() {
        return accessibleEntrance;
    }

    public void setAccessibleEntrance(String accessibleEntrance) {
        this.accessibleEntrance = accessibleEntrance;
    }

    public String getAccessibleSeating() {
        return accessibleSeating;
    }

    public void setAccessibleSeating(String accessibleSeating) {
        this.accessibleSeating = accessibleSeating;
    }

    public String getAccessibleRestRoom() {
        return accessibleRestRoom;
    }

    public void setAccessibleRestRoom(String accessibleRestRoom) {
        this.accessibleRestRoom = accessibleRestRoom;
    }

    public HotSpot getHotSpot() {
        return hotSpot;
    }

    public void setHotSpot(HotSpot hotSpot) {
        this.hotSpot = hotSpot;
    }

    public static Location of (CreateLocationDto createLocationDto){
        Location location = new Location();
        location.setAccessibleSeating(createLocationDto.getAccessibleSeating());
        location.setAccessibleEntrance(createLocationDto.getAccessibleEntrance());
        location.setAccessibleRestRoom(createLocationDto.getAccessibleRestRoom());
        location.setGoogleApiCode(createLocationDto.getGoogleApiCode());
        location.setBusinessStatus("ACTIVE");
        location.setFormattedAddress(createLocationDto.getFormattedAddress());
        location.setName(createLocationDto.getName());
        location.setLongitude("");
        location.setLatitude("");
        location.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        location.setLastUpdated(Timestamp.valueOf(LocalDateTime.now()));

        HotSpot hotSpot1 = new HotSpot();
        hotSpot1.setId(Integer.parseInt(createLocationDto.getHotspotId()));
        location.setHotSpot(hotSpot1);
        return location;
    }
}
