package com.mohamed.halim.javaeats.mapper;

import com.mohamed.halim.javaeats.dto.request.UserRegistration;
import com.mohamed.halim.javaeats.dto.response.UserDto;
import com.mohamed.halim.javaeats.jwt.JwtService;
import com.mohamed.halim.javaeats.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class UserMapper {
    private final JwtService jwtService;
    @Mapping(source = "username", target = "name")
    public abstract AppUser fromUserRegistration(UserRegistration registration);

    public abstract UserDto fromAppUser(AppUser user);

    @BeforeMapping
    private void generateJwt(@MappingTarget UserDto userDto, AppUser appUser) {
        userDto.setJwt(jwtService.generateToken(appUser));
    }
}
