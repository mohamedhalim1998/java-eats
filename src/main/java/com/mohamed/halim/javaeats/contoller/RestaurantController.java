package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.dto.filters.RestaurantFilter;
import com.mohamed.halim.javaeats.dto.response.RestaurantDto;
import com.mohamed.halim.javaeats.model.Restaurant;
import com.mohamed.halim.javaeats.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController extends CrudController<Restaurant,Long, RestaurantDto> {

    private final RestaurantService service;
    public RestaurantController(RestaurantService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/filtered")
    public List<RestaurantDto> getFiltered(@RequestBody RestaurantFilter filter) {
        return service.getFiltered(filter);
    }
}
