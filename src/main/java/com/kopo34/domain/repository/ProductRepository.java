package com.kopo34.domain.repository;

import java.util.List;

import com.kopo34.data.ProductRepositoryDbImple;
import com.kopo34.data.dao.MySqlProductDaoImpl;
import com.kopo34.domain.model.Product;

public interface ProductRepository {
	
	public static ProductRepository getInstance() {
		return new ProductRepositoryDbImple(new MySqlProductDaoImpl());
	}
	
	public List<Product> getAllProducts();
	
	public Product getProductById(String id);
	
	public void addProduct(Product product);
}
