<%@page import="com.kopo34.domain.repository.ProductRepository"%>
<%@page import="com.kopo34.domain.model.Product"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- <jsp:useBean id="repository" class="com.kopo34.data.ProductRepository" scope="session"></jsp:useBean> --%>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
  <jsp:include page="menu.jsp"></jsp:include>
  
    <div class="p-5 bg-primary text-white">
    <div class="container">
      <h1 class="display-3">
        상품 목록
      </h1>
    </div>
  </div>
  
  <div class="container">
    <div class="row" align="center">
    	<%
    	// 오브젝트를 리턴하기 때문에 맞는 타입으로 캐스팅해주면 됨. 오브젝트는 모든 타입으로 캐스팅이 가능하다.
    	    	// String name = (String) session.getAttribute("name");
    	    	// int age = (int) session.getAttribute("age");
    	    	
    	    	// out.print(session.getAttribute("foods"));
    	    	
    	    	// 싱글턴 패턴
    	      // ProductRepository repository = ProductRepository.getInstance();
    	    	// List<Product> products = (List<Product>) session.getAttribute("products"); do는 오류가 많으니까 일단 원래 코드로..
    	    	List<Product> products = ProductRepository.getInstance().getAllProducts();
    	    	for (int i = 0; i < products.size(); i++) {
    	    		Product product = products.get(i);
    	%>
      <div class="col-md-4">
        <h3><%= product.getName() %></h3>
        <p><%= product.getDescription() %></p>
        <p><%= product.getUnitPrice() %>원</p>
        <p><a href="product.jsp?id=<%= product.getId() %>" class="btn btn-secondary">상세 정보 &raquo;</a></p>
      </div>
      <%
    	}
      %>
    </div>
  </div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>