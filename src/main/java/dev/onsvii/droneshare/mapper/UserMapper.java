package dev.onsvii.droneshare.mapper;

import dev.onsvii.droneshare.dto.SignUpRequest;
import dev.onsvii.droneshare.dto.UserPrivateDTO;
import dev.onsvii.droneshare.dto.UserPublicDTO;
import dev.onsvii.droneshare.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserPublicDTO toPublicDto(User user) {
        if (user == null) return null;

        return new UserPublicDTO(
                user.getUsername(),
                user.getRating(),
                user.getCreatedAt().toLocalDate()
        );
    }

    public UserPrivateDTO toPrivateDto(User user) {
        if (user == null) return null;

        return new UserPrivateDTO(
                user.getId(),
                user.getRole(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getRating(),
                user.getCreatedAt().toLocalDate()
        );
    }

    public User toEntity(SignUpRequest dto) {
        if (dto == null) return null;

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setRole(User.Role.USER);

        return user;
    }
}