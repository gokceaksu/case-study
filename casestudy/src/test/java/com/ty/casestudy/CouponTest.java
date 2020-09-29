package com.ty.casestudy;

import org.junit.Assert;
import org.junit.Test;

public class CouponTest {
	
	@Test
	public void welcomeCouponTest() {

		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);
		SubCategory laptopCategory = new SubCategory(CategoryEnum.LAPTOP);

		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);
		Product vivobook = new Product("vivobook", 10000.0, laptopCategory);

		cart.addToCart(apple, 5);
		cart.addToCart(vivobook, 1);

		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 11000, 0.0);

		cart.addCoupon(new WelcomeCoupon());

		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 10990, 0.0);
	}

}
