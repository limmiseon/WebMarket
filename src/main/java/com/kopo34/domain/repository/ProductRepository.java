package com.kopo34.domain.repository;

import java.util.List;

import com.kopo34.data.ProductRepositoryImpl;
import com.kopo34.domain.model.Product;

public interface ProductRepository {
	
	public static ProductRepository getInstance() {
		return ProductRepositoryImpl.getInstance();
	}
	
	public List<Product> getAllProducts();
	public Product getProductById(String id);
	public void addProduct(Product product);
}
