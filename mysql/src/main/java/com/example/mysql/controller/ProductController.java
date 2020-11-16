package com.example.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.entity.Product;
import com.example.mysql.service.ProductService;

@RestController()
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/saveProducts")
	public List<Product> saveProducts(@RequestBody List<Product> products) {
		return service.saveAll(products);
	}

	@GetMapping("/products")
	public List<Product> findAllProduct() {
		return service.getProducts();
	}
	
	@GetMapping("/productById/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/productByName/{name}")
	public Product getProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProductById(id);
	}
}









