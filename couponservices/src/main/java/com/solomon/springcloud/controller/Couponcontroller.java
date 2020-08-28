package com.solomon.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solomon.springcloud.model.Coupon;
import com.solomon.springcloud.repo.Couponrepository;



@RestController
@RequestMapping("/couponapi")
public class Couponcontroller {
	
	@Autowired
	Couponrepository cuponRepo;
	
	@PostMapping("/coupon")
	public Coupon setCupon(@RequestBody Coupon coupon) {
		return cuponRepo.save(coupon);
	}
	
	@GetMapping("/coupon/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return cuponRepo.findByCode(code);
	}

}
