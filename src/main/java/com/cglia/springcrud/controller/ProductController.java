package com.cglia.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.springcrud.bean.ProductBean;

import com.cglia.springcrud.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")


public class ProductController {

	@Autowired
	private ProductService productservice;

	@Autowired
	public ProductController(ProductService productService) {
		this.productservice = productService;
	}

	@GetMapping("/products")
	public List<ProductBean> getAllProducts() {
		return productservice.getAllProducts();
	}

	@PostMapping(value = "/addproducts")
	public String addProduct(@RequestBody ProductBean productbean) {
		productservice.addProduct(productbean);
		return "Added Successfully";
	}

	@PutMapping(value = "/updateproducts/{id}")
	public void updateProduct(@PathVariable int id, @RequestBody ProductBean productbean) {
		productservice.updateProduct(id, productbean);
	}

	@DeleteMapping(value = "/deleteproducts/{id}")
	public String deleteProduct(@PathVariable int id) {

		productservice.deleteProduct(id);
		return "DeletedSuccesfully";

	}

}
