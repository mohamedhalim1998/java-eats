package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.service.CrudService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 * @param <T> entity
 */
@RequiredArgsConstructor
public abstract class CrudController<T, ID, M> {
    @Getter
    private final CrudService<T, ID, M> service;

    @GetMapping
    public List<M> getAll() {
        return service.getAll();
    }


}

