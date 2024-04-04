package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.dto.request.UserLogin;
import com.mohamed.halim.javaeats.dto.request.UserRegistration;
import com.mohamed.halim.javaeats.dto.response.UserDto;
import com.mohamed.halim.javaeats.model.Customer;
import com.mohamed.halim.javaeats.service.CustomerUserService;
import com.mohamed.halim.javaeats.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/V1/user/customer")
public class CustomerController extends UserController<Customer> {

    public CustomerController(CustomerUserService userService) {
        super(userService);
    }
}
