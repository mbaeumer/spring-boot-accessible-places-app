package se.mbaeumer.accessible.places.hotspots;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
