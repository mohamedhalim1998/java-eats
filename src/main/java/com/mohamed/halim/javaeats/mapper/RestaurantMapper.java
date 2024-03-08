package com.mohamed.halim.javaeats.mapper;

import com.mohamed.halim.javaeats.dto.response.RestaurantDto;
import com.mohamed.halim.javaeats.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends BaseMapper<Restaurant, RestaurantDto> {


    RestaurantDto toDto(Restaurant entity);

    Restaurant fromDto(RestaurantDto entity);
}
