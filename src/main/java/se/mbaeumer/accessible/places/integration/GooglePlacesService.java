package se.mbaeumer.accessible.places.integration;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GooglePlacesService {
    private final GooglePlacesClient googlePlacesClient;

    public GooglePlacesService(GooglePlacesClient googlePlacesClient) {
        this.googlePlacesClient = googlePlacesClient;
    }

    public String runTextSearch(){
        /*
        String apiKey = googlePlacesClient.fetchApiKey();
        return apiKey;

         */
        Mono<String> stringMono = googlePlacesClient.textSearch("Packhusplatsen 2, Göteborg");
        String block = stringMono.block();
        System.out.println("response: " + block);
        return block;
    }

    public String runNearBySearch(){
        String longitude="11.961514099999999";
        String latitude="57.707975999999995";
        String radius="500";

        NearBySearchRequest nearBy = new NearBySearchRequest(longitude, latitude, radius, 20, new String[]{"restaurant"});

        Mono<String> stringMono = googlePlacesClient.nearbySearch(nearBy);
        return stringMono.block();
    }
}
