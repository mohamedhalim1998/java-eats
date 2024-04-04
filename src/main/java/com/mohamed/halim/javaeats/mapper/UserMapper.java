package com.mohamed.halim.javaeats.mapper;

import com.mohamed.halim.javaeats.dto.request.UserRegistration;
import com.mohamed.halim.javaeats.dto.response.UserDto;
import com.mohamed.halim.javaeats.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

public interface UserMapper<T extends AppUser> {
    @Mapping(source = "username", target = "name")
    public abstract T fromUserRegistration(UserRegistration registration);

    public abstract UserDto fromAppUser(T user);
}

