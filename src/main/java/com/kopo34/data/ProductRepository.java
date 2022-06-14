package com.kopo34.data;

import java.util.ArrayList;
import java.util.List;

import com.kopo34.domain.model.Product;
// 기능 담당. 상품에 대한 모든 기능을 담당한다.
public class ProductRepository {
//	다형성
//	public static void main(String[] args) {
//		List<Product> products1 = new LinkedList<>();
//		List<Product> products2 = new ArrayList<>();
//	}
//	LinkedList와 ArrayList 차이
//	ArrayList -> 기본 array와 동일
//	기본 배열은 크기가 커지면 삽입/삭제 속도가 느림. but 내부적으로는 배열이라 성능이 빠르다.
//	linked list는 크기가 커져도 삽입/삭제 속도가 동일함, but ArrayList보다 검색이 느림. 메모리 더 많이 먹음.
//	private List<Product> products = new LinkedList<>();
//	앞에 List는 뭐야? 인터페이스. List 인터페이스(배열의 기능들을 단순 이름만 정의)를 ArrayList 또는 LinkedList로 구현한 것.
//	
//	왜 ArrayList말고 List를 쓰나? 다형성
//	private List<Product> products = new ArrayList<>();
//
//
//	public static List<Product> sort(List<Product> products) {
//		// 정렬...
//		return new ArrayList<>();
//	}
	
	private List<Product> products = new ArrayList<>();
	
//	싱글턴 패턴 (하나의 인스턴스만 갖게 하는 패턴)
//	1. static 인스턴스 준비
//	2. static 메서드로 인스턴스 리턴(getInstace() 이름을 주로 씀)
//	3. 생성자 막기
	private static ProductRepository instance = new ProductRepository();
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	// 생성자를 private로 막고 getInstance 함수로만 객체를 생성 가능
	// 자바빈즈와 함께 쓰려면 기본 생성자를 public으로 해줘야 함. 생성자가 막혀있으면 자바빈즈의 룰에 어긋나서 오류가 난다.
	private ProductRepository() {
		Product phone = new Product("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334x750 Retina HD display");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitPrice(1000);
		phone.setCondition("New");
		
		Product notebook = new Product("P1235", "LG PC 그램", 1500000);
		notebook.setDescription("!4.7-inch, 1334x750 Retina HD display");
		notebook.setCategory("!Smart Phone");
		notebook.setManufacturer("!Apple");
		notebook.setUnitPrice(1000);
		notebook.setCondition("Refubished");
		
		Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
		tablet.setDescription("?4.7-inch, 1334x750 Retina HD display");
		tablet.setCategory("?Smart Phone");
		tablet.setManufacturer("?Apple");
		tablet.setUnitPrice(1000);
		tablet.setCondition("Old");
		
		products.add(phone);
		products.add(notebook);
		products.add(tablet);
	}
	
	public List<Product> getAllProducts() {
		return products;
	}
	
	public Product getProductById(String id) {
		// p.173 참고
		// List -> Stream (데이터의 흐름) 리스트는 그냥 데이트가 있는거고 스트림은 데이터를 흘려 보냄
		// filter에 if문 조건을 쓴다.
		return products.stream()
						.filter((product) -> product.getId().equals(id)) // 조건에 맞는 애들 거르기
						.findFirst() // 첫번째거
						.get(); // 얻기
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
}
