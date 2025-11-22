package dev.onsvii.droneshare.repository;

import dev.onsvii.droneshare.model.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByAuthorId(Long authorId, Pageable pageable);
    List<Review> findByBookingListingId(Long id,  Pageable pageable);
}
