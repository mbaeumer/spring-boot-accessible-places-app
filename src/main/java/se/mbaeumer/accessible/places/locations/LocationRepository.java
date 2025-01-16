package se.mbaeumer.accessible.places.locations;

import org.springframework.data.jpa.repository.JpaRepository;
import se.mbaeumer.accessible.places.integration.NearBySearchResponse;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    List<Location> findByHotSpotId(int hotSpotId);
}
