package se.mbaeumer.accessible.places.requesttracking;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import se.mbaeumer.accessible.places.users.AppUser;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
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

    @Scheduled(timeUnit = TimeUnit.MINUTES, fixedRate = 1, initialDelay = 0)
    public void trackRequest(){
        AppUser appUser = new AppUser();
        appUser.setId(1);
        GoogleRequestType googleRequestType = new GoogleRequestType();
        googleRequestType.setId(1);
        GoogleRequest googleRequest = new GoogleRequest();
        googleRequest.setPayload("some payload");
        googleRequest.setExecutionTime(Timestamp.valueOf(LocalDateTime.now()));
        googleRequest.setRequestType(googleRequestType);
        googleRequest.setUser(appUser);
        System.out.println("trying to save a google request");
        googleRequestRepository.save(googleRequest);
    }
}
