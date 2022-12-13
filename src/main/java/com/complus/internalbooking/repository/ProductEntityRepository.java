package com.complus.internalbooking.repository;

import com.complus.internalbooking.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductEntityRepository extends JpaRepository<Product,String> {

    Optional<Product> findById(String id);

}
