package com.kopo34.data.dao;

import java.util.List;

import com.kopo34.domain.model.Product;

//MySql용
public class MySqlProductDaoImpl implements ProductDao {
	
	public MySqlProductDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로드
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패"); // 로드 실패시 죽이기
		}
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

}
