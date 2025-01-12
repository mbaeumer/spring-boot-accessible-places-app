package se.mbaeumer.accessible.places.integration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class TextSearchResponse {

    @JsonProperty("places")
    private List<Place> places;

    // Method to deserialize JSON string into TextSearchResponse
    public static TextSearchResponse fromJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, TextSearchResponse.class);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Place {
        @JsonProperty("id")
        private String id;

        @JsonProperty("formattedAddress")
        private String formattedAddress;

        @JsonProperty("location")
        private Location location;

        @JsonProperty("displayName")
        private DisplayName displayName;

        // Getters and setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public DisplayName getDisplayName() {
            return displayName;
        }

        public void setDisplayName(DisplayName displayName) {
            this.displayName = displayName;
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Location {
        @JsonProperty("latitude")
        private double latitude;

        @JsonProperty("longitude")
        private double longitude;

        // Getters and setters
        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DisplayName {
        @JsonProperty("text")
        private String text;

        @JsonProperty("languageCode")
        private String languageCode;

        // Getters and setters
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLanguageCode() {
            return languageCode;
        }

        public void setLanguageCode(String languageCode) {
            this.languageCode = languageCode;
        }
    }

    // Getters and setters for TextSearchResponse
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}

