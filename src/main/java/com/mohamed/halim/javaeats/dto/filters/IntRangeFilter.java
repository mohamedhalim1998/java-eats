package com.mohamed.halim.javaeats.dto.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntRangeFilter implements RangeFilter<Integer> {
    private Integer min;
    private Integer max;
}
