package com.solomon.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solomon.springcloud.model.Coupon;

public interface Couponrepository extends JpaRepository<Coupon,Long>
{

	Coupon findByCode(String code);

}
