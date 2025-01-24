package se.mbaeumer.accessible.places.locations;

import org.springframework.web.bind.annotation.*;
import se.mbaeumer.accessible.places.hotspots.HotSpotDto;

import java.util.List;

@RestController
@RequestMapping("/locations")
@CrossOrigin
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("")
    public List<LocationDto> getAllLocations(){
        return locationService.getAllLocations();
    }

    @GetMapping("/hotspot/{hotspotId}")
    public List<LocationDto> getLocationsForHotspot(@PathVariable(name="hotspotId") String hotspotId){
        return locationService.getLocationsForHotspot(hotspotId);
    }

    @PostMapping("/sync")
    public List<LocationDto> getLocationsFromApi(@RequestBody HotSpotDto hotSpotDto){
        System.out.println("Hotspot data: " + hotSpotDto.getLatitude());
        return locationService.getLocationsFromApi(hotSpotDto);
    }

    @PostMapping("")
    public void saveLocation(@RequestBody CreateLocationDto createLocationDto){
        System.out.println("Hotspot data: " + createLocationDto.getHotspotId());
        locationService.createLocation(createLocationDto);
    }


}
