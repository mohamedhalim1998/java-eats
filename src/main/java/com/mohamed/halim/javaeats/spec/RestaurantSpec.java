package com.mohamed.halim.javaeats.spec;

import com.mohamed.halim.javaeats.dto.filters.RestaurantFilter;
import com.mohamed.halim.javaeats.model.Restaurant;
import com.mohamed.halim.javaeats.model.Restaurant_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Objects;

@RequiredArgsConstructor
public class RestaurantSpec implements Specification<Restaurant> {
    private final transient RestaurantFilter filter;
    @Override
    public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        var predicates = new ArrayList<Predicate>();
        if (Objects.nonNull(filter.getId())) {
            predicates.add(criteriaBuilder.equal(root.get(Restaurant_.ID), filter.getId()));
        }
        if (Objects.nonNull(filter.getIds())) {
            var ids = filter.getIds().split(",");
            predicates.add(criteriaBuilder.in(root.get(Restaurant_.ID)).value(ids));
        }
        if (Objects.nonNull(filter.getIdRange())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(Restaurant_.ID), filter.getIdRange().getMin()));
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(Restaurant_.ID), filter.getIdRange().getMax()));
        }
        if (Objects.nonNull(filter.getName())) {
            predicates.add(criteriaBuilder.like(root.get(Restaurant_.name), SpecUtils.formatForLikeOperator(filter.getName())));
        }
        if (Objects.nonNull(filter.getDescription())) {
            predicates.add(criteriaBuilder.like(root.get(Restaurant_.description), SpecUtils.formatForLikeOperator(filter.getDescription())));
        }
        if (Objects.nonNull(filter.getLocation())) {
            predicates.add(criteriaBuilder.like(root.get(Restaurant_.location), SpecUtils.formatForLikeOperator(filter.getLocation())));
        }
        if (Objects.nonNull(filter.getCreatedAt())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(Restaurant_.createdAt), filter.getCreatedAt().getMin()));
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(Restaurant_.createdAt), filter.getCreatedAt().getMax()));
        }
        if (Objects.nonNull(filter.getUpdatedAt())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(Restaurant_.createdAt), filter.getUpdatedAt().getMin()));
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(Restaurant_.createdAt), filter.getUpdatedAt().getMax()));
        }

        return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
    }
}
