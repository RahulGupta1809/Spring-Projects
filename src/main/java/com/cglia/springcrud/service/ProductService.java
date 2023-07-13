package com.cglia.springcrud.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.cglia.springcrud.bean.ProductBean;
import com.cglia.springcrud.repository.ProductRepository;

@Service

public class ProductService {

	@Autowired
	public ProductRepository productRepo;

	public List<ProductBean> getAllProducts() {
		List<ProductBean> products = new ArrayList<>();
		productRepo.findAll().forEach(products::add);
		return products;
	}
	

	public void addProduct(ProductBean products) {
		productRepo.save(products);
	}

	public ProductBean updateProduct(int id, ProductBean updatedProduct) {
		ProductBean existingProduct = productRepo.findById(id).orElse(null);
		if (existingProduct != null) {

			existingProduct.setName(updatedProduct.getName());
			existingProduct.setPrice(updatedProduct.getPrice());
			existingProduct.setQuantity(updatedProduct.getQuantity());

			productRepo.save(existingProduct);
		}
		return null;
	}

	public void deleteProduct(int id) {
		productRepo.deleteById(id);
		;
	}

}
