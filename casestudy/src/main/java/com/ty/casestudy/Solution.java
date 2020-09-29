package com.ty.casestudy;

public class Solution {
	
	
	public static Category generalCategory = new MainCategory(CategoryEnum.GENERAL);
	public static Category foodCategory = new MainCategory(CategoryEnum.FOOD);
	public static Category cleaningCategory = new MainCategory(CategoryEnum.CLEANING);
	public static Category electronicsCategory = new MainCategory(CategoryEnum.ELECTRONICS);
	public static Category computerCategory = new MainCategory(CategoryEnum.COMPUTER);
	public static Category tvCategory = new MainCategory(CategoryEnum.TV);
	
	public static SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);
	public static SubCategory bakeryCategory = new SubCategory(CategoryEnum.BAKERY);
	public static SubCategory kitchenCleaningCategory = new SubCategory(CategoryEnum.KITCHEN_CLEANING);
	public static SubCategory laptopCategory = new SubCategory(CategoryEnum.LAPTOP);
	
	
	public static Category initializeCategoryTree() {
		
		foodCategory.addChild(greenGroceryCategory);
		foodCategory.addChild(bakeryCategory);
		cleaningCategory.addChild(kitchenCleaningCategory);
		computerCategory.addChild(laptopCategory);
		
		electronicsCategory.addChild(computerCategory);
		electronicsCategory.addChild(tvCategory);
		
		generalCategory.addChild(foodCategory);
		generalCategory.addChild(cleaningCategory);
		generalCategory.addChild(electronicsCategory);
		
		greenGroceryCategory.addCampaign(new SilverCampaign());
		kitchenCleaningCategory.addCampaign(new GoldCampaign());
		
		generalCategory.addCampaign(new DefaultCampaign());
		
		return generalCategory;
	}
	
	public static void main(String args[]) {
		
		initializeCategoryTree();
		
		Product apple = new Product("apple", 200.0, greenGroceryCategory);
		Product soap = new Product("soap", 100.0, kitchenCleaningCategory);
		
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart(apple, 5);
		cart.addToCart(soap, 3);
		
		cart.addCoupon(new WelcomeCoupon());
		
		IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorBasic();
		Double result = deliveryCostCalculator.calculateDeliveryCost(cart);
		
		System.out.println(generalCategory.showCategoryTree(" "));
		
		System.out.println(result);
	}
	
}
