package se.mbaeumer.accessible.places.users;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "AppUserType")
public class AppUserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String description;

    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AppUser> appUsers;

    // Getters and Setters
}
