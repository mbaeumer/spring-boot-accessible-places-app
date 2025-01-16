package se.mbaeumer.accessible.places.locations;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDto> getAllLocations(){
        List<Location> locations = locationRepository.findAll();

        List<LocationDto> locationDtos = locations.stream()
                .map(LocationDto::of)
                .collect(Collectors.toList());

        return locationDtos;
    }

    public List<LocationDto> getLocationsForHotspot(String hotspotId){
        List<Location> locationsByHotSpotId = locationRepository.findByHotSpotId(Integer.parseInt(hotspotId));

        List<LocationDto> locationDtos = locationsByHotSpotId.stream().map(LocationDto::of)
                .collect(Collectors.toList());
        return locationDtos;

    }
}
