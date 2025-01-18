package se.mbaeumer.accessible.places.locations;

import org.springframework.stereotype.Service;
import se.mbaeumer.accessible.places.hotspots.HotSpotDto;
import se.mbaeumer.accessible.places.integration.GooglePlacesService;
import se.mbaeumer.accessible.places.integration.NearBySearchResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final GooglePlacesService googlePlacesService;
    private final LocationRepository locationRepository;

    public LocationService(GooglePlacesService googlePlacesService, LocationRepository locationRepository) {
        this.googlePlacesService = googlePlacesService;
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

    public List<LocationDto> getLocationsFromApi(HotSpotDto hotSpotDto){

        NearBySearchResponse nearBySearchResponse = googlePlacesService.runNearBySearch(hotSpotDto);
        List<LocationDto> locationDtos = nearBySearchResponse.getPlaces().stream()
                .map(LocationDto::of).collect(Collectors.toList());
        return locationDtos;
    }
}
