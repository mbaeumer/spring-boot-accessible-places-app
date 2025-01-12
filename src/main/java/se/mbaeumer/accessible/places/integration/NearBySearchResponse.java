package se.mbaeumer.accessible.places.integration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class NearBySearchResponse {

    @JsonProperty("places")
    private List<Place> places;

    public static NearBySearchResponse fromJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, NearBySearchResponse.class);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Place {
        @JsonProperty("id")
        private String id;

        @JsonProperty("formattedAddress")
        private String formattedAddress;

        @JsonProperty("location")
        private Location location;

        @JsonProperty("businessStatus")
        private String businessStatus;

        @JsonProperty("displayName")
        private DisplayName displayName;

        @JsonProperty("accessibilityOptions")
        private AccessibilityOptions accessibilityOptions;

        // Getters and setters
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Location {
        @JsonProperty("latitude")
        private double latitude;

        @JsonProperty("longitude")
        private double longitude;

        // Getters and setters
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DisplayName {
        @JsonProperty("text")
        private String text;

        @JsonProperty("languageCode")
        private String languageCode;

        // Getters and setters
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AccessibilityOptions {
        @JsonProperty("wheelchairAccessibleParking")
        private Boolean wheelchairAccessibleParking;

        @JsonProperty("wheelchairAccessibleEntrance")
        private Boolean wheelchairAccessibleEntrance;

        @JsonProperty("wheelchairAccessibleRestroom")
        private Boolean wheelchairAccessibleRestroom;

        @JsonProperty("wheelchairAccessibleSeating")
        private Boolean wheelchairAccessibleSeating;

        // Getters and setters
    }

    // Getters and setters for NearBySearchResponse
}

