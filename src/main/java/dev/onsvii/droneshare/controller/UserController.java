package dev.onsvii.droneshare.controller;

import dev.onsvii.droneshare.dto.UserPrivateDTO;
import dev.onsvii.droneshare.dto.UserPublicDTO;
import dev.onsvii.droneshare.security.UserDetailsImpl;
import dev.onsvii.droneshare.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserPrivateDTO> getCurrentUserInfo(
            @AuthenticationPrincipal UserDetailsImpl userDetails) {

        return ResponseEntity.ok(userService.getUserPrivateInfoById(userDetails.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPublicDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserPublicInfoById(id));
    }

}
