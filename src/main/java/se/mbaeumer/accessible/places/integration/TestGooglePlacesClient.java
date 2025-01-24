package se.mbaeumer.accessible.places.integration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
//@Profile("test")
public class TestGooglePlacesClient implements GooglePlacesClient{

    private final WebClient webClient;

    private final GooglePlacesConfiguration googlePlacesConfiguration;

    private final VaultService vaultService;

    public TestGooglePlacesClient(WebClient.Builder webClientBuilder, GooglePlacesConfiguration googlePlacesConfiguration, VaultService vaultService) {
        this.webClient = webClientBuilder.baseUrl("https://places.googleapis.com/v1").build();
        this.googlePlacesConfiguration = googlePlacesConfiguration;
        this.vaultService = vaultService;
    }
    @Override
    public String fetchApiKey() {
        return vaultService.getVault();
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
    }}
