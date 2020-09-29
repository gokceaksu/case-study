package com.ty.casestudy;

public class WelcomeCoupon implements ICoupon {

	@Override
	public Double getCartDiscount(Double totalCartCost) {

		if (totalCartCost > 100.0) {
			return 10.0;
		}
		return 0.0;
	}
}
