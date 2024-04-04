package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.dto.request.UserLogin;
import com.mohamed.halim.javaeats.dto.request.UserRegistration;
import com.mohamed.halim.javaeats.dto.response.UserDto;
import com.mohamed.halim.javaeats.model.Admin;
import com.mohamed.halim.javaeats.service.AdminUserService;
import com.mohamed.halim.javaeats.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/V1/user/admin")
public class AdminController extends UserController<Admin> {

    public AdminController(AdminUserService userService) {
        super(userService);
    }
}
