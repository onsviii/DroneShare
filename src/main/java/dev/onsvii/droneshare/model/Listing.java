package dev.onsvii.droneshare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "listings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    private String title;
    private String description;
    private BigDecimal pricePerDay;

    @Embedded
    private Location location;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<Category> categories;

    public enum Category {
        DRONE, GOGGLES, CONTROLLER, OTHER
    }
}
