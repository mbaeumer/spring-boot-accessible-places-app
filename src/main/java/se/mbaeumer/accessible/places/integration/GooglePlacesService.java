package se.mbaeumer.accessible.places.integration;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class GooglePlacesService {
    private final GooglePlacesClient googlePlacesClient;

    public GooglePlacesService(GooglePlacesClient googlePlacesClient) {
        this.googlePlacesClient = googlePlacesClient;
    }

    public TextSearchResponse runTextSearch(String query){
        // TODO: Use parameter instead of hard-coded address
        // TODO: Map API response to DTO
        Mono<String> stringMono = googlePlacesClient.textSearch(query);
        String jsonResponse = stringMono.block();
        TextSearchResponse textSearchResponse;
        try {
            textSearchResponse = TextSearchResponse.fromJson(jsonResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return textSearchResponse;
    }

    public NearBySearchResponse runNearBySearch(){
        // TODO: Use parameter instead of hard-coded address

        String longitude="11.961514099999999";
        String latitude="57.707975999999995";
        String radius="500";

        NearBySearchRequest nearBy = new NearBySearchRequest(longitude, latitude, radius, 20, new String[]{"restaurant"});

        Mono<String> stringMono = googlePlacesClient.nearbySearch(nearBy);
        String jsonResponse = stringMono.block();
        NearBySearchResponse nearBySearchResponse;
        try {
            nearBySearchResponse = NearBySearchResponse.fromJson(jsonResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nearBySearchResponse;

    }
}
