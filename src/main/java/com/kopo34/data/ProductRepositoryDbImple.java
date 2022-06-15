package com.kopo34.data;

import java.util.Collections;
import java.util.List;

import com.kopo34.data.dao.ProductDao;
import com.kopo34.domain.model.Product;
import com.kopo34.domain.repository.ProductRepository;

public class ProductRepositoryDbImple implements ProductRepository {
	private ProductDao dao;
 
	public ProductRepositoryDbImple(ProductDao dao) { // ProductDao -> 인터페이스로 받으면 mysql, oracle 모두 받기 가능
		this.dao = dao;
	}
	
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	

}
