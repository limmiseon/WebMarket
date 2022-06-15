package com.kopo34.data.dao;

import java.util.List;

import com.kopo34.domain.model.Product;

// Data Access Object
// DB랑 연결할 객체
public interface ProductDao {
	// interface 안에서는 public 생략되어 있고, public 만 됨
	List<Product> getAll();
	
	void insert(Product product);
	
	void update(Product product);
	
	void delete(Product product);
	
}
