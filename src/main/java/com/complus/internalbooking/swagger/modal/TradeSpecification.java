package com.complus.internalbooking.swagger.modal;

import com.complus.internalbooking.repository.entity.Product;
import com.complus.internalbooking.repository.entity.Trade;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.complus.internalbooking.config.Constants.filterCriteriaList;

public class TradeSpecification implements Specification<Trade> {

    private List<SearchCriteria> criteriaList;

    public TradeSpecification(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public Predicate toPredicate
            (Root<Trade> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        Set<Predicate> predicateList = new HashSet<>();
        for (SearchCriteria criteria : criteriaList) {
            if(filterCriteriaList.contains(criteria.getKey())) {
                Path productRootPath = root.get("product");
                Path brokerRootPath = root.get("broker");
                switch (criteria.getKey()){
                    case "type":
                        predicateList.add(builder.equal(productRootPath.get("type"), criteria.getValue().toString()));
                        break;
                    case "subType":
                        predicateList.add(builder.equal(productRootPath.get("subType"), criteria.getValue().toString()));
                        break;
                    case "brokerId":
                        predicateList.add(builder.equal(brokerRootPath.get("id"), criteria.getValue().toString()));
                        break;
                    default:
                        predicateList.add(builder.equal(root.get(criteria.getKey()), criteria.getValue().toString()));;
                }
            }
        };

        Predicate[] pre = new Predicate[predicateList.size()];
        pre = predicateList.toArray(pre);

        return query.where(pre).getRestriction();
    }
}
