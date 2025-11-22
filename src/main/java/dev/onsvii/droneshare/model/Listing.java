package dev.onsvii.droneshare.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "listings")
@Getter
@Setter
@ToString(exclude = {"owner", "categories"})
@NoArgsConstructor
@AllArgsConstructor
public class Listing extends SoftDeletableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private BigDecimal pricePerDay;

    @Column(nullable = false)
    @Embedded
    private Location location;

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Category> categories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Listing)) return false;
        Listing listing = (Listing) o;

        return id != null && Objects.equals(id, listing.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public enum Category {
        DRONE, GOGGLES, CONTROLLER, OTHER
    }
}
