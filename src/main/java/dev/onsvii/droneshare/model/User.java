package dev.onsvii.droneshare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String username;
    private String email;
    private String password;
    private String phone;
    private double rating;
    private boolean isDeleted;

    public enum Role {
        USER, ADMIN
    }
}
