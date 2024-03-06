package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.dto.request.UserLogin;
import com.mohamed.halim.javaeats.dto.request.UserRegistration;
import com.mohamed.halim.javaeats.dto.response.UserDto;
import com.mohamed.halim.javaeats.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@RequestBody UserRegistration registration) {
        return userService.registerUser(registration);
    }

    @PostMapping("/login")
    public UserDto userLogin(@RequestBody UserLogin login) {
        return userService.loginUser(login);
    }
}
