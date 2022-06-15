package com.kopo34.domain.repository;

import java.util.List;

import com.kopo34.data.ProductRepositoryDbImple;
import com.kopo34.data.ProductRepositoryImpl;
import com.kopo34.data.dao.MySqlProductDaoImpl;
import com.kopo34.domain.model.Product;

public interface ProductRepository {
	
	public static ProductRepository getInstance() {
		//return ProductRepositoryImpl.getInstance(); 메모리에 붙는 거
		return new ProductRepositoryDbImple(new MySqlProductDaoImpl()); // MySql DB에 붙는 거
		//return new ProductRepositoryDbImple(new OracleProductDaoImpl()); // Oracle DB에 붙는 거
	}
	
	public List<Product> getAllProducts();
	
	public Product getProductById(String id);
	
	public void addProduct(Product product);
}
