package com.example.mstapaz.service;

import com.example.mstapaz.entity.MattEntity;
import com.example.mstapaz.model.request.MattSearchRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MattSpecification implements Specification<MattEntity> {
    final MattSearchRequest mattCriteria;
    static final String PRICE="price";
    static final String DESCRIPTION="description";


    @Override
    public Predicate toPredicate(Root<MattEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate>predicates=new ArrayList<>();

        if (mattCriteria!=null){
            if (mattCriteria.getPriceFrom()!=0){

                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(PRICE),mattCriteria.getPriceFrom()));

            }
            if (mattCriteria.getPriceTo()!=0){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(PRICE),mattCriteria.getPriceTo()));
            }

            if (StringUtils.hasText(mattCriteria.getDescription())){
                predicates.add(criteriaBuilder.like(root.get(DESCRIPTION), "%"
                        +mattCriteria.getDescription()+"%"));
            }

        }


        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));






    }
}
