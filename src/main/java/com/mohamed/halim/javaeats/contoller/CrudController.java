package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.dto.response.BaseDto;
import com.mohamed.halim.javaeats.service.CrudService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * provide basic crud operation for database entity
 *
 * @param <T> -> represent the database entity type
 * @param <ID> -> represent the entity id type
 * @param <M> -> represent the dto object for this database entity
 */
@RequiredArgsConstructor
public abstract class CrudController<T, ID, M extends BaseDto<ID>> {
    @Getter
    private final CrudService<T, ID, M> service;

    @GetMapping
    public List<M> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public M getOne(@PathVariable ID id) {
        return service.findById(id);
    }

    @PostMapping
    public M create(@RequestBody @Valid M dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }

    @PostMapping("/upsert")
    public List<M> upsert(List<M> dtos) {
        return service.upsert(dtos);
    }

    @PutMapping("/{id}")
    public M update(@RequestBody M dto, @PathVariable ID id) {
       return service.update(dto, id);
    }

}

