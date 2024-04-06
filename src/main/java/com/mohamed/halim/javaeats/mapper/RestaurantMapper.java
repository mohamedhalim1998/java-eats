package com.mohamed.halim.javaeats.mapper;

import com.mohamed.halim.javaeats.dto.response.RestaurantDto;
import com.mohamed.halim.javaeats.model.Manager;
import com.mohamed.halim.javaeats.model.Restaurant;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends BaseMapper<Restaurant, RestaurantDto> {


    RestaurantDto toDto(Restaurant entity);

    Restaurant fromDto(RestaurantDto entity);

    @AfterMapping
    default void addManager(@MappingTarget Restaurant restaurant) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Manager manager = (Manager) authentication.getPrincipal();
        restaurant.setManager(manager);
    }
}
