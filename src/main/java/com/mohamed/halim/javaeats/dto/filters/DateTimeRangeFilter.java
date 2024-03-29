package com.mohamed.halim.javaeats.dto.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateTimeRangeFilter implements RangeFilter<LocalDateTime> {
    private LocalDateTime min;
    private LocalDateTime max;
}
