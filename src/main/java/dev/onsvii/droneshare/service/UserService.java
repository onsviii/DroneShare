package dev.onsvii.droneshare.service;

import dev.onsvii.droneshare.dto.UserPrivateDTO;
import dev.onsvii.droneshare.dto.UserPublicDTO;
import dev.onsvii.droneshare.mapper.UserMapper;
import dev.onsvii.droneshare.model.User;
import dev.onsvii.droneshare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username is already in use");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public UserPublicDTO getUserPublicInfoById(Long id) {
        return userMapper.toPublicDto(getUserById(id));
    }

    @Transactional(readOnly = true)
    public UserPrivateDTO getUserPrivateInfoById(Long id) {
        return userMapper.toPrivateDto(getUserById(id));
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
