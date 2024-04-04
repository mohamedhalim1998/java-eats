package com.mohamed.halim.javaeats.mapper;

import com.mohamed.halim.javaeats.model.Admin;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface AdminUserMapper extends UserMapper<Admin> {
}
