package com.mohamed.halim.javaeats.service;

import com.mohamed.halim.javaeats.mapper.BaseMapper;
import com.mohamed.halim.javaeats.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class CrudService<T, ID, M> {
    private final BaseRepository<T, ID> repository;
    private final BaseMapper<T, M> mapper;

    public List<M> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public List<M> getAll(Specification<T> specification) {
        return repository.findAll(specification).stream().map(mapper::toDto).toList();
    }

    public Optional<M> findById(ID id) {
        return repository.findById(id).map(mapper::toDto);
    }

}
