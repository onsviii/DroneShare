package dev.onsvii.droneshare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
    private Date expiration;
}
