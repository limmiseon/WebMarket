package com.kopo34.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		List<Product> results = new ArrayList<>();
		
		// Connection 객체 생성. try () 괄호 안에 쓰면 close 안해도 알아서 닫아줌
		String sql = "SELECT * FROM product";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.93:3308/kopoctc", "root", "kopo34");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String id = rs.getString("p_id"); // 컬럼명 또는 인덱스 번호를 넣는다. 인덱스는 1로 시작
				String name = rs.getString("p_name");
				int unitPrice = rs.getInt("p_unitPrice");
				String description = rs.getString("p_description");
				String category = rs.getString("p_category");
				String manufacturer = rs.getString("p_manufacturer");
				long unitsInStock = rs.getLong("p_unitsInStock");
				String condition = rs.getString("p_condition"); // 이런 노가다 작업을 해주는 객체가 dto 이다.
				
				Product product = new Product(id, name, unitPrice);
				product.setDescription(description);
				product.setCategory(category);
				product.setManufacturer(manufacturer);
				product.setUnitsInStock(unitsInStock);
				product.setCondition(condition);
				
				results.add(product);
			}
			
		} catch (SQLException e) {
			throw new IllegalStateException("DB 연결 실패" + e.getLocalizedMessage());
			// e 객체가 에러 메세지를 담고 있다.
		}
		return results;
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
