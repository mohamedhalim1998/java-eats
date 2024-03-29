package com.mohamed.halim.javaeats.dto.filters;

import org.springframework.data.jpa.domain.Specification;

public abstract class BaseFilter<T> {
    public abstract Specification<T> getSpec();
}
