package se.mbaeumer.accessible.places.hotspots;

import jakarta.persistence.*;
import se.mbaeumer.accessible.places.users.AppUser;

@Entity
@Table(name = "HotSpot")
public class HotSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String googleApiCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private AppUser user;

    // Getters and Setters
}
