package com.onlineproduct.controllers;

import com.onlineproduct.models.Product;
import com.onlineproduct.models.ProductDetail;
import com.onlineproduct.repositories.ProductDetailRepository;
import com.onlineproduct.repositories.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    //loading database with data
    @Bean
    CommandLineRunner initDB(ProductRepository productRepository, ProductDetailRepository productDetailRepository) {
        return args -> {
            log.info("Loading... " + productRepository.save(new Product("Explosion","gas bomb",786.5,23)));
            log.info("Loading... " + productRepository.save(new Product("Venom","cobra venom",300.25,5)));
            log.info("Loading... " + productRepository.save(new Product("Weapon","gun",850,17)));
            productDetailRepository.save(new ProductDetail("Explosion Description", "Explosion comment"));
            productDetailRepository.save(new ProductDetail("Venom Description", "Venom comment"));
            productDetailRepository.save(new ProductDetail("Weapon Description", "Weapon comment"));
            productDetailRepository.findAll().forEach(detail -> log.info("Preloaded " + detail));
        };
    }
}
