package com.codecool.repository;

import com.codecool.model.ProductBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBasketRepository extends JpaRepository<ProductBasket, Long> {
}
