package com.jesc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesc.exception.ProductException;
import com.jesc.model.Product;
import com.jesc.request.CreateProductRequest;
import com.jesc.response.ApiResponse;
import com.jesc.service.ProductService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest req){
		Product product = productService.createProduct(req);
		return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{productId}/delete")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws ProductException{
		productService.deleteProduct(productId);
		ApiResponse api = new ApiResponse();
		api.setMessage("Product deleted succesfully");
		api.setStatus(true);
		return new ResponseEntity<>(api, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProducts(){
		List<Product> products = productService.findAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@PutMapping("/{productId}/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product req, Long productId) throws ProductException{
		Product product = productService.updateProduct(productId, req);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	@PostMapping("/creates")
	public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] req){
		for(CreateProductRequest product : req) {
			productService.createProduct(product);
		}
		ApiResponse res = new ApiResponse();
		res.setMessage("Products created succcesfully");
		res.setStatus(true);
		return new ResponseEntity<ApiResponse>(res, HttpStatus.CREATED);
	}
}
