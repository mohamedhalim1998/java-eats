package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.dto.response.RestaurantDto;
import com.mohamed.halim.javaeats.model.Restaurant;
import com.mohamed.halim.javaeats.service.RestaurantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController extends CrudController<Restaurant,Long, RestaurantDto> {

    public RestaurantController(RestaurantService service) {
        super(service);
    }
}
