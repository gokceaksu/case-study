package com.ty.casestudy;

import java.util.Map;

public class DeliveryCostCalculatorBasic implements IDeliveryCostCalculator {

	
	public Double calculateDeliveryCost(ShoppingCart shoppingCart) {

		Double cost = 0.0;

		for (Map.Entry<Product, Integer> entry : shoppingCart.getProducts().entrySet()) {

			Product product = entry.getKey();
			Integer quantity = entry.getValue();

			Double discountAmount = product.getCategory().getTotalDiscountAmountOfCategory(quantity, product.getPrice());
			cost += (product.getPrice() - discountAmount) * quantity;
		}
		
		if (shoppingCart.hasCoupon()) {
			for (ICoupon iCoupon : shoppingCart.getCouponList()) {
				cost -= iCoupon.getCartDiscount(cost);
			}
		}

		return cost;
	}
}
