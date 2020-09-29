package com.ty.casestudy;

import org.junit.Assert;
import org.junit.Test;

public class CategoryTest {
	
	
	@Test
	public void getTotalDiscountAmountOfCategoryTest() {
		
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
		Assert.assertEquals(20.0, greenGroceryCategory.getTotalDiscountAmountOfCategory(5, 200.0), 0.0);
		
		generalCategory.addCampaign(new DefaultCampaign());
		Assert.assertEquals(30.0, greenGroceryCategory.getTotalDiscountAmountOfCategory(5, 200.0), 0.0);
	}

}
