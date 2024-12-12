package se.mbaeumer.accessible.places.requesttracking;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "GoogleRequestType")
public class GoogleRequestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "requestType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GoogleRequest> googleRequests;

    // Getters and Setters
}
