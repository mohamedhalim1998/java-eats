package com.mohamed.halim.javaeats.mapper;

import com.mohamed.halim.javaeats.dto.request.UserRegistration;
import com.mohamed.halim.javaeats.dto.response.UserDto;
import com.mohamed.halim.javaeats.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Mapping(source = "username", target = "name")
    public abstract AppUser fromUserRegistration(UserRegistration registration);

    public abstract UserDto fromAppUser(AppUser user);
}

