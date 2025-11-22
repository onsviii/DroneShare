package dev.onsvii.droneshare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;
}
