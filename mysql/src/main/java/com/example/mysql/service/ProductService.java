package com.example.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.entity.Product;
import com.example.mysql.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveAll(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteProductById(int id) {
		repository.deleteById(id);
		return "Product deleted with id: " + id;
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setPrice(product.getPrice());
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		
		return repository.save(existingProduct);
	}
}
