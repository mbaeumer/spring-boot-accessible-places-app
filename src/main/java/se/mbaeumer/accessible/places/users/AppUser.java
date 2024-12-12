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
}
