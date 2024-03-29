package com.mohamed.halim.javaeats.mapper;

import java.util.List;

public interface BaseMapper<T, M> {
    M toDto(T entity);

    T fromDto(M entity);

    default List<M> toDto(List<T> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    default List<T> fromDto(List<M> entities) {
        return entities.stream().map(this::fromDto).toList();
    }

}
