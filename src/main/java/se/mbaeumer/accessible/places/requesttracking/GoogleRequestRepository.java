package se.mbaeumer.accessible.places.requesttracking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoogleRequestRepository extends JpaRepository<GoogleRequest, Integer> {
}
