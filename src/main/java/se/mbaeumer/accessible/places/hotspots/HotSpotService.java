package se.mbaeumer.accessible.places.hotspots;

import org.springframework.stereotype.Service;
import se.mbaeumer.accessible.places.integration.GooglePlacesService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotSpotService {
    private final HotSpotRepository hotSpotRepository;

    private final GooglePlacesService googlePlacesService;

    public HotSpotService(HotSpotRepository hotSpotRepository, GooglePlacesService googlePlacesService) {
        this.hotSpotRepository = hotSpotRepository;
        this.googlePlacesService = googlePlacesService;
    }

    public List<HotSpotDto> getAllHotSpots(){
        List<HotSpot> hotSpots = hotSpotRepository.findAll();
        List<HotSpotDto> hotSpotDtos = hotSpots.stream()
                .map(HotSpotDto::of)
                .collect(Collectors.toList());
        return hotSpotDtos;
    }

    public void searchForHotSpot(String query){
        googlePlacesService.runTextSearch(query);
    }
}
