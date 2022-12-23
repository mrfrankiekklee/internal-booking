package com.complus.internalbooking.repository;

import com.complus.internalbooking.repository.entity.Broker;
import com.complus.internalbooking.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrokerEntityRepository extends JpaRepository<Broker,String> {

    Optional<Broker> findById(String id);
    Broker save(Broker broker);

}
