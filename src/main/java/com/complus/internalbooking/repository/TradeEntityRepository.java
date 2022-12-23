package com.complus.internalbooking.repository;

import com.complus.internalbooking.repository.entity.Trade;
import com.complus.internalbooking.swagger.modal.TradeSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeEntityRepository extends JpaRepository<Trade,String>, JpaSpecificationExecutor<Trade> {

    Trade save(Trade trade);

    List<Trade> findAll();
}
