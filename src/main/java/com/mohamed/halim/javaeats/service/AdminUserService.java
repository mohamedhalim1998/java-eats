package com.mohamed.halim.javaeats.service;

import com.mohamed.halim.javaeats.jwt.JwtService;
import com.mohamed.halim.javaeats.mapper.AdminUserMapper;
import com.mohamed.halim.javaeats.model.Admin;
import com.mohamed.halim.javaeats.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService extends UserService<Admin> {
    public AdminUserService(AdminRepository userRepository, PasswordEncoder encoder, AdminUserMapper userMapper, JwtService jwtService) {
        super(userRepository, encoder, userMapper, jwtService);
    }
}
