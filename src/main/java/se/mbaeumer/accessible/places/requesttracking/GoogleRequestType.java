package se.mbaeumer.accessible.places.requesttracking;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GoogleRequest> getGoogleRequests() {
        return googleRequests;
    }

    public void setGoogleRequests(List<GoogleRequest> googleRequests) {
        this.googleRequests = googleRequests;
    }
}
