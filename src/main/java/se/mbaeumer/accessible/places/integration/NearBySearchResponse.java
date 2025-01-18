package se.mbaeumer.accessible.places.integration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.util.List;

public class NearBySearchResponse {

    @JsonProperty("places")
    private List<Place> places;

    public static NearBySearchResponse fromJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        NearBySearchResponse response = objectMapper.readValue(json, NearBySearchResponse.class);
        response.places.stream().forEach(NearBySearchResponse::resetAccessibilityOptionsIfNull);

        return response;
    }

    private static void resetAccessibilityOptionsIfNull(Place place){
        if (place.getAccessibilityOptions() == null){
            AccessibilityOptions options = new AccessibilityOptions();
            options.setWheelchairAccessibleParking("MISSING");
            options.setWheelchairAccessibleEntrance("MISSING");
            options.setWheelchairAccessibleRestroom("MISSING");
            options.setWheelchairAccessibleSeating("MISSING");
            place.setAccessibilityOptions(options);
        }
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
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
        @JsonDeserialize(using = AccessibilityOptionsDeserializer.class)
        private AccessibilityOptions accessibilityOptions;

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

        public String getBusinessStatus() {
            return businessStatus;
        }

        public void setBusinessStatus(String businessStatus) {
            this.businessStatus = businessStatus;
        }

        public DisplayName getDisplayName() {
            return displayName;
        }

        public void setDisplayName(DisplayName displayName) {
            this.displayName = displayName;
        }

        public AccessibilityOptions getAccessibilityOptions() {
            return accessibilityOptions;
        }

        public void setAccessibilityOptions(AccessibilityOptions accessibilityOptions) {
            this.accessibilityOptions = accessibilityOptions;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AccessibilityOptions {
        @JsonProperty("wheelchairAccessibleParking")
        private String wheelchairAccessibleParking;

        @JsonProperty("wheelchairAccessibleEntrance")
        private String wheelchairAccessibleEntrance;

        @JsonProperty("wheelchairAccessibleRestroom")
        private String wheelchairAccessibleRestroom;

        @JsonProperty("wheelchairAccessibleSeating")
        private String wheelchairAccessibleSeating;

        // Getters and setters


        public String getWheelchairAccessibleParking() {
            return wheelchairAccessibleParking;
        }

        public void setWheelchairAccessibleParking(String wheelchairAccessibleParking) {
            this.wheelchairAccessibleParking = wheelchairAccessibleParking;
        }

        public String getWheelchairAccessibleEntrance() {
            return wheelchairAccessibleEntrance;
        }

        public void setWheelchairAccessibleEntrance(String wheelchairAccessibleEntrance) {
            this.wheelchairAccessibleEntrance = wheelchairAccessibleEntrance;
        }

        public String getWheelchairAccessibleRestroom() {
            return wheelchairAccessibleRestroom;
        }

        public void setWheelchairAccessibleRestroom(String wheelchairAccessibleRestroom) {
            this.wheelchairAccessibleRestroom = wheelchairAccessibleRestroom;
        }

        public String getWheelchairAccessibleSeating() {
            return wheelchairAccessibleSeating;
        }

        public void setWheelchairAccessibleSeating(String wheelchairAccessibleSeating) {
            this.wheelchairAccessibleSeating = wheelchairAccessibleSeating;
        }
    }

    public static class AccessibilityOptionsDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer<AccessibilityOptions> {
        @Override
        public AccessibilityOptions deserialize(com.fasterxml.jackson.core.JsonParser parser, com.fasterxml.jackson.databind.DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            var node = mapper.readTree(parser);

            AccessibilityOptions options = new AccessibilityOptions();
            options.setWheelchairAccessibleEntrance(getOptionValue((JsonNode) node, "wheelchairAccessibleEntrance"));
            options.setWheelchairAccessibleRestroom(getOptionValue((JsonNode) node, "wheelchairAccessibleRestroom"));
            options.setWheelchairAccessibleSeating(getOptionValue((JsonNode) node, "wheelchairAccessibleSeating"));
            options.setWheelchairAccessibleParking(getOptionValue((JsonNode) node, "wheelchairAccessibleParking"));

            return options;
        }

        private String getOptionValue(com.fasterxml.jackson.databind.JsonNode node, String fieldName) {
            if (node.has(fieldName)) {
                return node.get(fieldName).asBoolean() ? "YES" : "NO";
            }
            return "MISSING";
        }
    }

    // Getters and setters for NearBySearchResponse


}

