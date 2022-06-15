<%@page import="com.kopo34.domain.model.Product"%>
<%@page import="com.kopo34.domain.repository.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// ProductController로 자바 코드들 넘겨줌..
// 한글 처리
request.setCharacterEncoding("UTF-8");
// POST로 넘어온 것
String productId = request.getParameter("productId");
String name = request.getParameter("name");
int unitPrice = Integer.valueOf(request.getParameter("unitPrice"));
String description = request.getParameter("description");
String manufacturer = request.getParameter("manufacturer");
String category = request.getParameter("category");
int unitsInStock = Integer.valueOf(request.getParameter("unitsInStock"));
String condition = request.getParameter("condition");

ProductRepository repository = ProductRepository.getInstance();
Product product = new Product(productId, name, unitPrice);
product.setDescription(description);
product.setManufacturer(manufacturer);
product.setCategory(category);
product.setUnitsInStock(unitsInStock);
product.setCondition(condition);

repository.addProduct(product);
//response는 응답객체로, 요청한애한테 다시 응답을 준다. (다시 돌아옴)
response.sendRedirect("products.jsp");
%>