package se.mbaeumer.accessible.places.requesttracking;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoogleRequestTrackingController {

    private final GoogleRequestRepository googleRequestRepository;

    public GoogleRequestTrackingController(GoogleRequestRepository googleRequestRepository) {
        this.googleRequestRepository = googleRequestRepository;
    }

    public List<GoogleRequest> getAllRequests(){
        return googleRequestRepository.findAll();
    }
}
