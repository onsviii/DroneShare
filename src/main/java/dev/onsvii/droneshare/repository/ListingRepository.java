package dev.onsvii.droneshare.repository;

import dev.onsvii.droneshare.model.Listing;
import dev.onsvii.droneshare.model.Location;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByOwnerId(Long ownerId, Pageable pageable);
    List<Listing> findByLocation(Location location, Pageable pageable);
}
