package com.mohamed.halim.javaeats.service;

import com.mohamed.halim.javaeats.dto.response.BaseDto;
import com.mohamed.halim.javaeats.mapper.BaseMapper;
import com.mohamed.halim.javaeats.repository.BaseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
/**
 *
 * @param <T> -> represent the database entity type
 * @param <ID> -> represent the entity id type
 * @param <M> -> represent the dto object for this database entity
 */
@RequiredArgsConstructor
public abstract class CrudService<T, ID, M extends BaseDto<ID>> {
    protected final BaseRepository<T, ID> repository;
    protected final BaseMapper<T, M> mapper;

    public List<M> getAll() {
        return mapper.toDto(repository.findAll());
    }

    public List<M> getAll(Specification<T> specification) {
        return mapper.toDto(repository.findAll(specification));
    }

    public M findById(ID id) {
        var entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return mapper.toDto(entity.get());
    }

    public M create(M dto) {
        var entity = repository.save(mapper.fromDto(dto));
        return mapper.toDto(entity);
    }

    public M update(M dto, ID id) {
        var entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    public List<M> upsert(List<M> dtos) {
        return dtos.stream().map(dto -> {
            if (Objects.isNull(dto.getId())) {
                return update(dto, dto.getId());
            } else {
                return create(dto);
            }
        }).toList();
    }


}
