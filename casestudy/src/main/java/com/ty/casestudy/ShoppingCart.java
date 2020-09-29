package com.ty.casestudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {
	

	private HashMap<Product, Integer> products;

	private List<ICoupon> couponList;

	
	public ShoppingCart() {
		products = new HashMap<>();
		couponList = new ArrayList<>();
	}

	public void addToCart(Product product, Integer quantity) {

		Integer count = products.getOrDefault(product, 0);
		products.put(product, count + quantity);
	}

	public HashMap<Product, Integer> getProducts() {
		return products;
	}

	public List<ICoupon> getCouponList() {
		return couponList;
	}

	public void addCoupon(ICoupon coupon) {
		getCouponList().add(coupon);
	}

	public Boolean hasCoupon() {
		return !getCouponList().isEmpty() ? true : false;
	}

}
