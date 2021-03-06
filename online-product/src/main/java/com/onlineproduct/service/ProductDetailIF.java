package com.onlineproduct.service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import com.onlineproduct.models.ProductDetail;

public interface ProductDetailIF 
{
	public abstract CollectionModel<EntityModel<ProductDetail>> all();
	public abstract ResponseEntity<?> newDetail(ProductDetail newProductDetail);
	public abstract EntityModel<ProductDetail> one(Long id);
	public abstract ResponseEntity<?> replaceDetail(ProductDetail newProductDetail,Long id);
	public abstract ResponseEntity<?> deleteDetail(Long id);
}
