package se.mbaeumer.accessible.places.integration;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import se.mbaeumer.accessible.places.hotspots.HotSpotDto;

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

    public NearBySearchResponse runNearBySearch(HotSpotDto hotSpotDto){

        NearBySearchRequest nearBy = NearBySearchRequest.from(hotSpotDto);

        Mono<String> stringMono = googlePlacesClient.nearbySearch(nearBy);
        String jsonResponse = stringMono.block();
        NearBySearchResponse nearBySearchResponse;
        try {
            System.out.println("json response from Google: " + jsonResponse);
            nearBySearchResponse = NearBySearchResponse.fromJson(jsonResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return nearBySearchResponse;
    }
}
