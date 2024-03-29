package com.mohamed.halim.javaeats.dto.filters;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.mohamed.halim.javaeats.model.Restaurant;
import com.mohamed.halim.javaeats.spec.RestaurantSpec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.jpa.domain.Specification;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestaurantFilter extends BaseFilter<Restaurant> {
    private Long id;
    private String ids;
    private IntRangeFilter idRange;
    private String name;
    private String description;
    private String location;
    private DateTimeRangeFilter createdAt;
    private DateTimeRangeFilter updatedAt;

    @Override
    public Specification<Restaurant> getSpec() {
        return new RestaurantSpec(this);
    }
}
