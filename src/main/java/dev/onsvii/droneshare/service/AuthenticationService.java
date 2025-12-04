package dev.onsvii.droneshare.service;

import dev.onsvii.droneshare.dto.JwtAuthenticationResponse;
import dev.onsvii.droneshare.dto.SignInRequest;
import dev.onsvii.droneshare.dto.SignUpRequest;
import dev.onsvii.droneshare.model.User;
import dev.onsvii.droneshare.security.JwtService;
import dev.onsvii.droneshare.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;

    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        User user = User.builder()
                .role(User.Role.USER)
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .build();

        userService.create(user);
        String token = jwtService.generateToken(new UserDetailsImpl(user));

        return new JwtAuthenticationResponse(token, jwtService.extractExpiration(token));
    }

    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getLogin(),
                request.getPassword()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        String token = jwtService.generateToken(userDetails);

        return new JwtAuthenticationResponse(token, jwtService.extractExpiration(token));
    }
}
