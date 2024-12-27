package se.mbaeumer.accessible.places.requesttracking;

import jakarta.persistence.*;
import se.mbaeumer.accessible.places.users.AppUser;

import java.sql.Timestamp;

@Entity
@Table(name = "GoogleRequest")
public class GoogleRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Timestamp getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Timestamp executionTime) {
        this.executionTime = executionTime;
    }

    public GoogleRequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(GoogleRequestType requestType) {
        this.requestType = requestType;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
