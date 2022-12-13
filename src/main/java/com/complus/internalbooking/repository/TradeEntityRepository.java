package com.complus.internalbooking.repository;

import com.complus.internalbooking.repository.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeEntityRepository extends JpaRepository<Trade,String> {

    Trade save(Trade trade);

    List<Trade> findAll();
}
