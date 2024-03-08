package com.mohamed.halim.javaeats.mapper;

public interface BaseMapper<T, M> {
    M toDto(T entity);

    T fromDto(M entity);
}
