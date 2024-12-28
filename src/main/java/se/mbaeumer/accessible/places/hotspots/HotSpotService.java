package se.mbaeumer.accessible.places.hotspots;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotSpotService {
    private final HotSpotRepository hotSpotRepository;

    public HotSpotService(HotSpotRepository hotSpotRepository) {
        this.hotSpotRepository = hotSpotRepository;
    }

    public List<HotSpotDto> getAllHotSpots(){
        List<HotSpot> hotSpots = hotSpotRepository.findAll();
        List<HotSpotDto> hotSpotDtos = hotSpots.stream()
                .map(HotSpotDto::of)
                .collect(Collectors.toList());
        return hotSpotDtos;
    }
}
