package se.mbaeumer.accessible.places.locations;

import jakarta.persistence.*;
import se.mbaeumer.accessible.places.users.AppUser;

import java.sql.Timestamp;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
