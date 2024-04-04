package com.mohamed.halim.javaeats.mapper;

import com.mohamed.halim.javaeats.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerUserMapper extends UserMapper<Customer> {
}
