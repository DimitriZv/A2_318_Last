package com.onlineproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onlineproduct.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{}
