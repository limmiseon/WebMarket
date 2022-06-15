package com.kopo34.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kopo34.domain.model.Product;
import com.kopo34.domain.repository.ProductRepository;

@WebServlet(name = "ProductController", urlPatterns = {"/products.do", "/processAddProduct.do"})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = -7221076946923982531L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req = request
		// 요청 주소 (products.do) 얻기
		String command = req.getRequestURI().substring(req.getContextPath().length());
		ProductRepository repository = ProductRepository.getInstance();
		
		if (command.equals("/products.do")) {
	    	List<Product> products = repository.getAllProducts();
	    	req.getSession().setAttribute("products", products);

		} else if (command.equals("/processAddProduct.do")) { // addProduct.jsp 전달 방식이 post라서 원래는 doPost에서 해야되는데 시간 없어서 일단 여기다,,
			// 한글 처리
			req.setCharacterEncoding("UTF-8");
			// POST로 넘어온 것
			String productId = req.getParameter("productId");
			String name = req.getParameter("name");
			int unitPrice = Integer.valueOf(req.getParameter("unitPrice"));
			String description = req.getParameter("description");
			String manufacturer = req.getParameter("manufacturer");
			String category = req.getParameter("category");
			int unitsInStock = Integer.valueOf(req.getParameter("unitsInStock"));
			String condition = req.getParameter("condition");

			// ProductRepository repository = ProductRepository.getInstance();
			Product product = new Product(productId, name, unitPrice);
			product.setDescription(description);
			product.setManufacturer(manufacturer);
			product.setCategory(category);
			product.setUnitsInStock(unitsInStock);
			product.setCondition(condition);

			repository.addProduct(product);
			// response는 응답객체로, 요청한애한테 다시 응답을 준다. (다시 돌아옴)
			// response.sendRedirect("products.jsp");
		}
			
		System.out.println("통과!!!!!!!!!!!!!!");
		
		// products.jsp 로 이동
		req.getRequestDispatcher("products.jsp").forward(req, resp);
		// super.doPost(req, resp); <- 지워도 됨
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// super.doPost(req, resp); <- 지워도 됨
	}

	

}
