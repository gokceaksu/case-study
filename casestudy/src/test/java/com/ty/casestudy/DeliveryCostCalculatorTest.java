package com.ty.casestudy;

import org.junit.Assert;
import org.junit.Test;

public class DeliveryCostCalculatorTest {

	
	/* ONLY ONE LEVEL CATEGORY (NO PARENTS) */
	
	@Test
	public void test_noCampaigns_noCoupons() {

		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);
		SubCategory kitchenCleaningCategory = new SubCategory(CategoryEnum.KITCHEN_CLEANING);
		
		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);

		cart.addToCart(apple, 5);
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 1000, 0.0);

		Product soap = new Product("soap", 100.0, kitchenCleaningCategory);
		cart.addToCart(soap, 3);

		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 1300, 0.0);
	}

	/* WITH PARENT CATEGORIES */
	
	@Test
	public void test_parent_noCampaigns_noCoupons() {
		
		Category generalCategory = new MainCategory(CategoryEnum.GENERAL);
		Category foodCategory = new MainCategory(CategoryEnum.FOOD);
		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);

		foodCategory.addChild(greenGroceryCategory);
		generalCategory.addChild(foodCategory);
		
		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);

		cart.addToCart(apple, 5);
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 1000, 0.0);
	}

}
