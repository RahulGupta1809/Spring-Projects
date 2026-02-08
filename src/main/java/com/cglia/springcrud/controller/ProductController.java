package com.cglia.springcrud.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger =
			LoggerFactory.getLogger(ProductController.class);

	private final ProductService productservice;

	@Autowired
	public ProductController(ProductService productService) {
		this.productservice = productService;
	}

	@GetMapping("/products")
	public List<ProductBean> getAllProducts() {
		logger.info("Fetching all products");
		List<ProductBean> products = productservice.getAllProducts();
		logger.info("Total products fetched: {}", products.size());
		return products;
	}

	@PostMapping("/addproducts")
	public String addProduct(@RequestBody ProductBean productbean) {
		logger.info("Adding new product: {}", productbean);
		productservice.addProduct(productbean);
		logger.info("Product added successfully");
		return "Added Successfully";
	}

	@PutMapping("/updateproducts/{id}")
	public void updateProduct(@PathVariable int id,
							  @RequestBody ProductBean productbean) {
		logger.info("Updating product with id: {}", id);
		productservice.updateProduct(id, productbean);
		logger.info("Product updated successfully for id: {}", id);
	}

	@DeleteMapping("/deleteproducts/{id}")
	public String deleteProduct(@PathVariable int id) {
		logger.info("Deleting product with id: {}", id);
		productservice.deleteProduct(id);
		logger.info("Product deleted successfully for id: {}", id);
		return "Deleted Successfully";
	}
}

