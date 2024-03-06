package com.mohamed.halim.javaeats.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLogin {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
