package com.ty.casestudy;

import org.junit.Assert;
import org.junit.Test;

public class DeliveryCostCalculatorWithCampaignsTest {

	
	/* ONLY ONE LEVEL CATEGORY (NO PARENTS) */
	
	@Test
	public void test_withCampaigns_noCoupons() {

		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);
		SubCategory kitchenCleaningCategory = new SubCategory(CategoryEnum.KITCHEN_CLEANING);
		
		greenGroceryCategory.addCampaign(new SilverCampaign());
		kitchenCleaningCategory.addCampaign(new GoldCampaign());
		
		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);
		Product soap = new Product("soap", 100.0, kitchenCleaningCategory);
		
		cart.addToCart(apple, 5);
		cart.addToCart(soap, 3);
		
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 1125, 0.0);
	}
	

	/* WITH PARENT CATEGORIES */
	
	@Test
	public void test_parent_withCampaigns_noCoupons() {
		
		Category generalCategory = new MainCategory(CategoryEnum.GENERAL);
		Category foodCategory = new MainCategory(CategoryEnum.FOOD);
		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);

		foodCategory.addChild(greenGroceryCategory);
		generalCategory.addChild(foodCategory);
		
		greenGroceryCategory.addCampaign(new SilverCampaign());
		generalCategory.addCampaign(new GoldCampaign());
		
		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);

		cart.addToCart(apple, 5);
		
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 650, 0.0);
	}
	
}
