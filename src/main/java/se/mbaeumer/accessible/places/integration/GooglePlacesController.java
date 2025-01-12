package se.mbaeumer.accessible.places.integration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class GooglePlacesController {
    private final GooglePlacesService googlePlacesService;

    public GooglePlacesController(GooglePlacesService googlePlacesService) {
        this.googlePlacesService = googlePlacesService;
    }

    @GetMapping("/textsearch")
    public String showResponse(){
        return googlePlacesService.runTextSearch("Packhusplatsen 2, Göteborg");
    }

    @GetMapping("/nearby")
    public NearBySearchResponse showNearByResponse(){
        return googlePlacesService.runNearBySearch();
    }




}
