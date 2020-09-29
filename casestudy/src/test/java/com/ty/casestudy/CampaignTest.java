package com.ty.casestudy;

import org.junit.Assert;
import org.junit.Test;

public class CampaignTest {
	
	
	@Test
	public void goldCampaignTest() {
		
		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);

		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);

		cart.addToCart(apple, 5);
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 1000, 0.0);
		
		greenGroceryCategory.addCampaign(new GoldCampaign());
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 750, 0.0);
	}
	
	@Test
	public void silverCampaignTest() {
		
		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);

		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);

		cart.addToCart(apple, 5);
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 1000, 0.0);
		
		greenGroceryCategory.addCampaign(new SilverCampaign());
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 900, 0.0);
	}
}
