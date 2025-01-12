package se.mbaeumer.accessible.places.integration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
@Profile("dev")
public class LocalGooglePlacesClient implements GooglePlacesClient{

    private final WebClient webClient;

    public LocalGooglePlacesClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://places.googleapis.com/v1").build();
    }

    @Override
    public String fetchApiKey() {
        try {
            return readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFile() throws IOException {
        String everything;
        BufferedReader br = new BufferedReader(new FileReader("/Users/martinbaumer/Documents/gitrepo/spring-boot-accessible-places-app/src/main/resources/apikey/apikey.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }

        String apiKey = everything.stripTrailing();
        return apiKey;
    }

    public Mono<String> textSearch(String textQuery) {
        return webClient.post()
                .uri("/places:searchText")
                .header("X-Goog-Api-Key", fetchApiKey())
                .header("X-Goog-FieldMask", "places.id,places.displayName,places.formattedAddress,places.location")
                .header("Content-Type", "application/json")
                .bodyValue("{" +
                        "\"textQuery\": \"" + textQuery + "\"}" )
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class, e -> Mono.error(new RuntimeException("Error during text search", e)));
    }

    public Mono<String> nearbySearch(NearBySearchRequest nearBySearchRequest) {
        String requestBody = String.format("""
            {
                \"includedTypes\": %s,
                \"maxResultCount\": %d,
                \"locationRestriction\": {
                    \"circle\": {
                        \"center\": {
                            \"latitude\": %s,
                            \"longitude\": %s
                        },
                        \"radius\": %s
                    }
                }
            }
            """,
                toJsonArray(nearBySearchRequest.getIncludeTypes()), nearBySearchRequest.getMaxResults(),
                nearBySearchRequest.getLatitude(), nearBySearchRequest.getLongitude(), nearBySearchRequest.getRadius());

        System.out.println("request body: " + requestBody);
        return webClient.post()
                .uri("/places:searchNearby")
                .header("X-Goog-Api-Key", fetchApiKey())
                .header("X-Goog-FieldMask", "places.id,places.displayName,places.formattedAddress,places.location,places.accessibilityOptions,places.businessStatus")
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class, e -> Mono.error(new RuntimeException("Error during nearby search", e)));
    }

    private String toJsonArray(String[] array) {
        StringBuilder jsonArray = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            jsonArray.append("\"").append(array[i]).append("\"");
            if (i < array.length - 1) {
                jsonArray.append(",");
            }
        }
        jsonArray.append("]");
        return jsonArray.toString();
    }
}
