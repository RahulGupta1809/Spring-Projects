package com.cglia.springcrud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cglia.springcrud.bean.ProductBean;

@Repository
public interface ProductRepository extends JpaRepository<ProductBean, Integer> {
}


