package com.mohamed.halim.javaeats.service;

import com.mohamed.halim.javaeats.dto.response.RestaurantDto;
import com.mohamed.halim.javaeats.mapper.RestaurantMapper;
import com.mohamed.halim.javaeats.model.Restaurant;
import com.mohamed.halim.javaeats.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends CrudService<Restaurant, Long, RestaurantDto> {
    public RestaurantService(RestaurantRepository repository, RestaurantMapper mapper) {
        super(repository, mapper);
    }
}
