package com.mohamed.halim.javaeats.service;

import com.mohamed.halim.javaeats.jwt.JwtService;
import com.mohamed.halim.javaeats.mapper.ManagerUserMapper;
import com.mohamed.halim.javaeats.model.Manager;
import com.mohamed.halim.javaeats.repository.ManagerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ManagerUserService extends UserService<Manager> {
    public ManagerUserService(ManagerRepository userRepository, PasswordEncoder encoder, ManagerUserMapper userMapper, JwtService jwtService) {
        super(userRepository, encoder, userMapper, jwtService);
    }
}
