package com.solomon.springcloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.solomon.springcloud.model.Coupon;
import com.solomon.springcloud.model.Products;
import com.solomon.springcloud.repos.ProductRepo;
import com.solomon.springcloud.restclients.CuponClient;

@RestController 
@RequestMapping("/productapi")
public class ProductController {
	
	@Autowired 
	CuponClient cuponClient;

	@Autowired
	ProductRepo productRepo;
	
	@HystrixCommand(fallbackMethod = "sendErrorMessage")
	@PostMapping("/product")
	public Products setProduct(@RequestBody Products product) {
		Coupon cupon = cuponClient.getCupon(product.getCuponCode());
		product.setPrice(product.getPrice().subtract(cupon.getDiscount()));
		return productRepo.save(product);
	}
	@GetMapping("/products")
    public List<Products> getProduct(Long id) {
		List<Products> pro = productRepo.findAll();
    	return pro;
    }
	//Fall Back Method 
	public Products sendErrorMessage(Products product) {
		return product;
	}

}
