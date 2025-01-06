package se.mbaeumer.accessible.places.integration;

import reactor.core.publisher.Mono;

public interface GooglePlacesClient {

    // basic search
    // near by search
    // detail request
    public String  fetchApiKey();

    Mono<String> textSearch(String text);

}
