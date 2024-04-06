package com.mohamed.halim.javaeats.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto implements BaseDto<Long> {
    private Long id;
    private String name;
    private String description;
    private String location;
}
