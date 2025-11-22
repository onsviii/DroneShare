package dev.onsvii.droneshare.repository;

import dev.onsvii.droneshare.model.Booking;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByTenantId(Long tenantId, Pageable pageable);
    List<Booking> findByListingId(Long listingId, Pageable pageable);
}
