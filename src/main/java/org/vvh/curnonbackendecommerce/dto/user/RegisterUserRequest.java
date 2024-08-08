package org.vvh.curnonbackendecommerce.dto.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String username;
    private String email;
    private String password;
}
