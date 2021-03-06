package com.onlineproduct.service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import com.onlineproduct.models.Product;

public interface ProductServiceIF //interface for product service
{
	public abstract CollectionModel<EntityModel<Product>> all();
	public abstract Product newProduct(Product newProduct);
	public abstract EntityModel<Product> one(Long id);
	public abstract Product replaceProduct(Product newProduct,Long id);
	public abstract Product updateProductDetail(Long id, Long detailId);
	public abstract void deleteProduct(Long id);
}
