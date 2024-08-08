package org.vvh.curnonbackendecommerce.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vvh.curnonbackendecommerce.dto.user.RegisterUserRequest;
import org.vvh.curnonbackendecommerce.entity.User;
import org.vvh.curnonbackendecommerce.enums.UserRole;
import org.vvh.curnonbackendecommerce.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void createUser(RegisterUserRequest request) {
        if(isUserExistsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if(!request.getEmail().isEmpty() && isUserExistsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(UserRole.CUSTOMER)
                .build();
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public boolean isUserExistsByUsernameOrEmail(String username, String email) {
        return userRepository.existsByUsernameOrEmail(username, email);
    }

    @Override
    public boolean isUserExistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
