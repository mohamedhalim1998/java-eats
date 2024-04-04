package com.mohamed.halim.javaeats.mapper;

import com.mohamed.halim.javaeats.model.Customer;
import com.mohamed.halim.javaeats.model.Manager;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerUserMapper extends UserMapper<Manager> {
}
