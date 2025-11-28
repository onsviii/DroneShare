package dev.onsvii.droneshare.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequest {
    @NotBlank(message = "Login (email or username) is required")
    private String login;

    @NotBlank(message = "Password is required")
    private String password;
}