package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.dto.request.UserLogin;
import com.mohamed.halim.javaeats.dto.request.UserRegistration;
import com.mohamed.halim.javaeats.dto.response.UserDto;
import com.mohamed.halim.javaeats.model.AppUser;
import com.mohamed.halim.javaeats.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
public abstract class UserController<T extends AppUser> {
    private final UserService<T> userService;

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
