package com.ty.casestudy;

import org.junit.Assert;
import org.junit.Test;

public class DeliveryCostCalculatorWithBothTest {

	
	/* ONLY ONE LEVEL CATEGORY (NO PARENTS) */

	@Test
	public void test_withCampaigns_withCoupons() {

		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);
		SubCategory laptopCategory = new SubCategory(CategoryEnum.LAPTOP);

		greenGroceryCategory.addCampaign(new SilverCampaign());
		laptopCategory.addCampaign(new DefaultCampaign());
		
		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);
		Product vivobook = new Product("vivobook", 10000.0, laptopCategory);

		cart.addToCart(apple, 5);
		cart.addToCart(vivobook, 1);

		cart.addCoupon(new WelcomeCoupon());
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 10890, 0.0);
	}
	

	/* WITH PARENT CATEGORIES */
	@Test
	public void test_parent_withCampaigns_withCoupons() {

		Category generalCategory = new MainCategory(CategoryEnum.GENERAL);
		Category foodCategory = new MainCategory(CategoryEnum.FOOD);
		Category electronicsCategory = new MainCategory(CategoryEnum.ELECTRONICS);
		Category computerCategory = new MainCategory(CategoryEnum.COMPUTER);
		Category tvCategory = new MainCategory(CategoryEnum.TV);
		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);
		SubCategory bakeryCategory = new SubCategory(CategoryEnum.BAKERY);
		SubCategory laptopCategory = new SubCategory(CategoryEnum.LAPTOP);

		foodCategory.addChild(greenGroceryCategory);
		foodCategory.addChild(bakeryCategory);
		computerCategory.addChild(laptopCategory);

		electronicsCategory.addChild(computerCategory);
		electronicsCategory.addChild(tvCategory);

		generalCategory.addChild(foodCategory);
		generalCategory.addChild(electronicsCategory);

		greenGroceryCategory.addCampaign(new SilverCampaign());
		generalCategory.addCampaign(new DefaultCampaign());

		ShoppingCart cart = new ShoppingCart();
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);
		Product vivobook = new Product("vivobook", 10000.0, laptopCategory);

		cart.addToCart(apple, 5);
		cart.addToCart(vivobook, 1);

		cart.addCoupon(new WelcomeCoupon());
		Assert.assertEquals(deliveryCostCalculator.calculateDeliveryCost(cart), 10840, 0.0);
	}

}
