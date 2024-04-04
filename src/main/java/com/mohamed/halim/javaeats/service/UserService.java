package com.mohamed.halim.javaeats.service;

import com.mohamed.halim.javaeats.dto.request.UserLogin;
import com.mohamed.halim.javaeats.dto.request.UserRegistration;
import com.mohamed.halim.javaeats.dto.response.UserDto;
import com.mohamed.halim.javaeats.exceptions.EmailAlreadyExistException;
import com.mohamed.halim.javaeats.exceptions.UserAlreadyExistException;
import com.mohamed.halim.javaeats.exceptions.WrongLoginException;
import com.mohamed.halim.javaeats.jwt.JwtService;
import com.mohamed.halim.javaeats.mapper.AdminUserMapper;
import com.mohamed.halim.javaeats.mapper.UserMapper;
import com.mohamed.halim.javaeats.model.AppUser;
import com.mohamed.halim.javaeats.repository.AdminRepository;
import com.mohamed.halim.javaeats.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public abstract class UserService<T extends AppUser>  {
    private final UserRepository<T> userRepository;
    private final PasswordEncoder encoder;
    private final UserMapper<T> userMapper;
    private final JwtService jwtService;

    public UserDto registerUser(UserRegistration registration) {
        var user = userMapper.fromUserRegistration(registration);
        validateUser(user);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setJwt(jwtService.generateToken(user));
        return userMapper.fromAppUser(userRepository.save(user));
    }

    private void validateUser(AppUser user) {
        if(userRepository.findByName(user.getName()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        if(userRepository.findByName(user.getName()).isPresent()) {
            throw new EmailAlreadyExistException();
        }

    }

    public UserDto loginUser(UserLogin login) {
        var user =  userRepository.findByEmail(login.getUsername())
                .orElseGet(() -> userRepository.findByName(login.getUsername())
                        .orElseThrow(WrongLoginException::new));
        if(!encoder.matches(login.getPassword(), user.getPassword())) {
            throw new WrongLoginException();
        }
        user.setJwt(jwtService.generateToken(user));
        return userMapper.fromAppUser(user);
    }
}
