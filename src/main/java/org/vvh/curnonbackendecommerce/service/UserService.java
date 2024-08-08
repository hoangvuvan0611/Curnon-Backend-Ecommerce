package org.vvh.curnonbackendecommerce.service;

import org.springframework.stereotype.Service;
import org.vvh.curnonbackendecommerce.dto.user.RegisterUserRequest;
import org.vvh.curnonbackendecommerce.entity.User;

public interface UserService {
    void createUser(RegisterUserRequest request);
    User getUserById(Long id);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
    boolean isUserExistsByUsernameOrEmail(String username, String email);
    boolean isUserExistsByUsername(String username);
    boolean isUserExistsByEmail(String email);
}