package com.kopo34.domain.model;

import java.util.Objects;

// 1. 무지성 private 멤버 변수
// 2. 필요하면 생성자 추가
// 3. 무지성 getter / setter : 읽기 전용, 쓰기 전용 구현
// 4. 무지성 toString 재정의 : 객체를 String으로 표현하고자 하면 재정의함
// 5. 필요하면 equals / hashCode 재정의
public class Product {
	// 메인 메소드와 Product는 무슨 관계가 있는가? 없다.
	// 그렇다면 왜 클래스 안에 메인 메소드가 있어야 하는가? 그냥 자바 룰,,
	// 그래서 프로그램 만들때 Main이라는 클래스 만들고 main 메소드를 만든다.
	// static 붙은 애들은 메모리에 바로 올라가기 때문에 같은 동네이므로 바로 접근 가능
//	public static void main(String[] args) {
//		Product product1 = new Product("33","11",1000);
//		Product product2 = new Product("33","11",1000);
//		
//		문자열 비교할 때
//		System.out.println("name" == "name"); 이라면
//		System.out.println(new String("name") == new String("name")); 이므로 해쉬코드가 다르다. false
	
//		재정의 후
//		System.out.println(product1.equals(product2)); // true
//		System.out.println(product1.hashCode() == product2.hashCode()); // true
//		System.out.println(product1 == product2); // false	
//	}
	
	private String id;
	private String name;
	private int unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private String condition;
	
	public Product(String id, String name, int unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", description=" + description
				+ ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock=" + unitsInStock
				+ ", condition=" + condition + "]";
	}
	
	
	
}
