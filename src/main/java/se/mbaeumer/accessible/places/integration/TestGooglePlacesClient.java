package se.mbaeumer.accessible.places.integration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Profile("test")
public class TestGooglePlacesClient implements GooglePlacesClient{

    private final GooglePlacesConfiguration googlePlacesConfiguration;

    public TestGooglePlacesClient(GooglePlacesConfiguration googlePlacesConfiguration) {
        this.googlePlacesConfiguration = googlePlacesConfiguration;
    }

    @Override
    public String fetchApiKey() {
        return googlePlacesConfiguration.getApiKey();
    }

    @Override
    public Mono<String> textSearch(String text) {
        return null;
    }

    @Override
    public Mono<String> nearbySearch(NearBySearchRequest nearBySearchRequest) {
        return null;
    }
}
