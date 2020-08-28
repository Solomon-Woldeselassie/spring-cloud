package com.solomon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CouponservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponservicesApplication.class, args);
	}

}
