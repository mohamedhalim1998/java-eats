package com.mohamed.halim.javaeats.dto.request;

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
    @NotBlank
    //TODO: try custom validation to validate this
    private String password;

}
