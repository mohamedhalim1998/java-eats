package com.mohamed.halim.javaeats.service;

import com.mohamed.halim.javaeats.mapper.BaseMapper;
import com.mohamed.halim.javaeats.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class CrudService<T, ID, M> {
    protected final BaseRepository<T, ID> repository;
    protected final BaseMapper<T, M> mapper;

    public List<M> getAll() {
        return mapper.toDto(repository.findAll());
    }

    public List<M> getAll(Specification<T> specification) {
        return mapper.toDto(repository.findAll(specification));
    }

    public Optional<M> findById(ID id) {
        return repository.findById(id).map(mapper::toDto);
    }

}
