package com.mohamed.halim.javaeats.service;

import com.mohamed.halim.javaeats.jwt.JwtService;
import com.mohamed.halim.javaeats.mapper.CustomerUserMapper;
import com.mohamed.halim.javaeats.model.Customer;
import com.mohamed.halim.javaeats.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserService extends UserService<Customer> {
    public CustomerUserService(CustomerRepository userRepository, PasswordEncoder encoder, CustomerUserMapper userMapper, JwtService jwtService) {
        super(userRepository, encoder, userMapper, jwtService);
    }
}
