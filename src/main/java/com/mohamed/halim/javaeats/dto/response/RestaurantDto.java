package com.mohamed.halim.javaeats.dto.response;

import com.mohamed.halim.javaeats.model.Manager;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto implements BaseDto<Long> {
    private Long id;
    private String name;
    private String description;
    private String location;
    private BigDecimal shippingCharges = BigDecimal.ZERO;
}
