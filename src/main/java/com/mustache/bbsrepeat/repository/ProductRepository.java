package com.mustache.bbsrepeat.repository;

import com.mustache.bbsrepeat.domain.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
