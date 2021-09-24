package com.onlineproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineproduct.models.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {}