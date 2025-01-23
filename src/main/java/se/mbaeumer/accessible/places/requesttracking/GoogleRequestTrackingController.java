package se.mbaeumer.accessible.places.requesttracking;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/requesttracking")
@CrossOrigin
public class GoogleRequestTrackingController {

    private final GoogleRequestService googleRequestService;

    public GoogleRequestTrackingController(GoogleRequestService googleRequestService) {
        this.googleRequestService = googleRequestService;
    }

    @GetMapping("")
    public List<GoogleRequestDto> getAllRequests(){
        return googleRequestService.getAllGoogleRequests();
    }
}
