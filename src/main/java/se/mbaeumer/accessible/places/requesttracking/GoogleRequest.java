package se.mbaeumer.accessible.places.requesttracking;

import jakarta.persistence.*;
import se.mbaeumer.accessible.places.users.AppUser;

import java.sql.Timestamp;

@Entity
@Table(name = "GoogleRequest")
public class GoogleRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String payload;

    @Column(nullable = false)
    private Timestamp executionTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requestTypeId")
    private GoogleRequestType requestType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private AppUser user;

    // Getters and Setters
}
