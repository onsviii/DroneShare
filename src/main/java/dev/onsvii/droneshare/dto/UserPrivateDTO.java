package dev.onsvii.droneshare.dto;

import dev.onsvii.droneshare.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPrivateDTO {
    private Long id;
    private User.Role role;
    private String username;
    private String email;
    private String phone;
    private double rating;
    private LocalDate registrationDate;
}
