package com.onlineproduct.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import com.onlineproduct.models.ProductDetail;
import com.onlineproduct.repositories.ProductDetailRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import com.onlineproduct.controllers.NotFoundException;
import com.onlineproduct.controllers.ProductModelAssembler;
import com.onlineproduct.models.Product;
import com.onlineproduct.repositories.ProductRepository;

@Service
public class ProductService implements ProductServiceIF
{
	//product repository and assembler
	private final ProductRepository productRepository;
    private final ProductModelAssembler assembler;
	private final ProductDetailRepository detailRepository;
    //private final
    //constructor of the product service
    public ProductService(ProductRepository repository, ProductModelAssembler assembler,
						  ProductDetailRepository detailRepository) {
        this.productRepository = repository;
        this.assembler = assembler;
        this.detailRepository = detailRepository;
    }
    //find all the products
	@Override
	public CollectionModel<EntityModel<Product>> all() {
		// TODO Auto-generated method stub
		List<EntityModel<Product>> products = productRepository.findAll().stream()
	            .map(assembler::toModel)
	            .collect(Collectors.toList());

	        return CollectionModel.of(products,
	        linkTo(methodOn(ProductService.class).all()).withSelfRel());
	}
	//create a new product
	@Override
	public Product newProduct(Product newProduct) {
		// TODO Auto-generated method stub
		return productRepository.save(newProduct);
	}
	//find product information by id
	@Override
	public EntityModel<Product> one(Long id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	    return assembler.toModel(product);
	}
	//update product
	@Override
	public Product replaceProduct(Product newProduct, Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id)
                .map(product -> {
                	product.setProductCategory(newProduct.getProductCategory());
                	product.setName(newProduct.getName());
                	product.setPrice(newProduct.getPrice());
                	product.setStockQuantity(newProduct.getStockQuantity());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                	newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
	}
	//delete product record
	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public Product updateProductDetail(Long id, Long detailId) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
		ProductDetail details = detailRepository.findById(detailId).orElseThrow(RuntimeException::new);
		product.setProductDetail(details);
		return productRepository.save(product);
	}
}
