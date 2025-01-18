package se.mbaeumer.accessible.places.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NearBySearchResponseTest {

    @Test
    void fromJsonWithMissingRestRoom() {

        String json = "{\n" +
                "  \"places\": [\n" +
                "    {\n" +
                "      \"id\": \"ChIJ16JcrWnzT0YRFDeNKgFBHhI\",\n" +
                "      \"formattedAddress\": \"Fisktorget 4, 411 20 Göteborg, Sweden\",\n" +
                "      \"location\": {\n" +
                "        \"latitude\": 57.7010542,\n" +
                "        \"longitude\": 11.9577603\n" +
                "      },\n" +
                "      \"businessStatus\": \"OPERATIONAL\",\n" +
                "      \"displayName\": {\n" +
                "        \"text\": \"Feskekörka\",\n" +
                "        \"languageCode\": \"en\"\n" +
                "      },\n" +
                "      \"accessibilityOptions\": {\n" +
                "        \"wheelchairAccessibleParking\": true,\n" +
                "        \"wheelchairAccessibleEntrance\": true,\n" +
                "        \"wheelchairAccessibleSeating\": true\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        try {
            NearBySearchResponse response = NearBySearchResponse.fromJson(json);
            NearBySearchResponse.Place place = response.getPlaces().get(0);
            Assertions.assertTrue("MISSING".equals(place.getAccessibilityOptions().getWheelchairAccessibleRestroom()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void froJsonWithMissingAccessibilityOptions(){
        String json = "{\n" +
                "  \"places\": [\n" +
                "    {\n" +
                "      \"id\": \"ChIJbRSLNDzzT0YRQeQxQe0rqqY\",\n" +
                "      \"formattedAddress\": \"Norra Allégatan 8, 413 30 Göteborg, Sweden\",\n" +
                "      \"location\": {\n" +
                "        \"latitude\": 57.700238899999995,\n" +
                "        \"longitude\": 11.9568202\n" +
                "      },\n" +
                "      \"businessStatus\": \"CLOSED_TEMPORARILY\",\n" +
                "      \"displayName\": {\n" +
                "        \"text\": \"Sukki-Ne\",\n" +
                "        \"languageCode\": \"sv\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
        try {
            NearBySearchResponse response = NearBySearchResponse.fromJson(json);
            NearBySearchResponse.Place place = response.getPlaces().get(0);
            Assertions.assertTrue("MISSING".equals(place.getAccessibilityOptions().getWheelchairAccessibleRestroom()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}