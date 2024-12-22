package se.mbaeumer.accessible.places.users;

import jakarta.persistence.*;
import se.mbaeumer.accessible.places.hotspots.HotSpot;
import se.mbaeumer.accessible.places.locations.Location;
import se.mbaeumer.accessible.places.requesttracking.GoogleRequest;

import java.util.List;

@Entity
@Table(name = "AppUser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userTypeId")
    private AppUserType userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GoogleRequest> googleRequests;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotSpot> hotSpots;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Location> locations;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUserType getUserType() {
        return userType;
    }

    public void setUserType(AppUserType userType) {
        this.userType = userType;
    }

    public List<GoogleRequest> getGoogleRequests() {
        return googleRequests;
    }

    public void setGoogleRequests(List<GoogleRequest> googleRequests) {
        this.googleRequests = googleRequests;
    }

    public List<HotSpot> getHotSpots() {
        return hotSpots;
    }

    public void setHotSpots(List<HotSpot> hotSpots) {
        this.hotSpots = hotSpots;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
