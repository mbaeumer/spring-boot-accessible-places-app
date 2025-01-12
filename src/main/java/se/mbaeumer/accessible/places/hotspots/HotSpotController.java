package se.mbaeumer.accessible.places.hotspots;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotspots")
@CrossOrigin
public class HotSpotController {

    private final HotSpotService hotSpotService;

    public HotSpotController(HotSpotService hotSpotService) {
        this.hotSpotService = hotSpotService;
    }

    @GetMapping("")
    public List<HotSpotDto> getAllHotSpots(){
        return hotSpotService.getAllHotSpots();
    }

    @GetMapping("/search")
    public void searchHotSpots(@RequestParam(name = "query") final String searchTerm){
        hotSpotService.searchForHotSpot(searchTerm);
    }
}
