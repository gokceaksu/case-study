package com.ty.casestudy;

import org.junit.Assert;
import org.junit.Test;

public class DeliveryCostCalculatorWithCouponsTest {

	
	@Test
	public void test_noCampaigns_withCoupons() {

		Category generalCategory = new MainCategory(CategoryEnum.GENERAL);
		Category foodCategory = new MainCategory(CategoryEnum.FOOD);
		Category cleaningCategory = new MainCategory(CategoryEnum.CLEANING);
		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);
		SubCategory kitchenCleaningCategory = new SubCategory(CategoryEnum.KITCHEN_CLEANING);
		
		foodCategory.addChild(greenGroceryCategory);
		cleaningCategory.addChild(kitchenCleaningCategory);
		generalCategory.addChild(foodCategory);
		generalCategory.addChild(cleaningCategory);

		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);
		Product soap = new Product("soap", 100.0, kitchenCleaningCategory);

		cart.addToCart(apple, 5);
		cart.addToCart(soap, 3);

		cart.addCoupon(new WelcomeCoupon());
		
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 1290, 0.0);
	}

}
