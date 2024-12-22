package se.mbaeumer.accessible.places.requesttracking;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoogleRequestService {

    private final GoogleRequestRepository googleRequestRepository;

    public GoogleRequestService(GoogleRequestRepository googleRequestRepository) {
        this.googleRequestRepository = googleRequestRepository;
    }

    public List<GoogleRequestDto> getAllGoogleRequests(){

        List<GoogleRequest> googleRequests = googleRequestRepository.findAll();
        List<GoogleRequestDto> googleRequestDtos = googleRequests.stream()
                .map(GoogleRequestDto::of)
                .collect(Collectors.toList());
        return googleRequestDtos;
    }
}
