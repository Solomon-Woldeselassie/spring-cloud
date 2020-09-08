package com.solomon.springcloud.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.solomon.springcloud.model.Coupon;

@FeignClient("zuul-api-gateway")
public interface CuponClient {
	@GetMapping("/coupon-services/couponapi/coupon/{code}")
	Coupon getCupon(@PathVariable("code") String code);

}
