package com.mohamed.halim.javaeats.dto.request;

import com.mohamed.halim.javaeats.validation.PasswordConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegistration {
    @NotBlank
    private String username;
    @NotBlank
    @Email
    private String email;
    @PasswordConstraint
    private String password;

}
