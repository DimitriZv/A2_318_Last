package com.onlineproduct.models;

import net.minidev.json.annotate.JsonIgnore;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Product 
{
	@Id
    @GeneratedValue
    private Long id;
    private String productCategory;
    private String name;
    private double price;
    private int stockQuantity;
    @OneToOne
    @JoinColumn(name = "detail_id")
    //@JoinColumn(name = "id")
    @JsonIgnore
    private ProductDetail productDetail;

    public Product() {}

    public Product(String productCategory, String name, double price, int stockQuantity) {
        this.productCategory = productCategory;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        //this.productDetail = null;
    }
    //accessors and mutators of the product
    public Long getId() {
        return id;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id)
                && Objects.equals(this.productCategory, product.productCategory)
                && Objects.equals(this.name, product.name)
                && Objects.equals(this.stockQuantity, product.stockQuantity)
                && Objects.equals(this.price, product.price)
                && Objects.equals(this.productDetail, product.productDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.productCategory, this.name, this.price, this.stockQuantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCategory='" + productCategory + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", productDetail=" + productDetail +
                '}';
    }
}
