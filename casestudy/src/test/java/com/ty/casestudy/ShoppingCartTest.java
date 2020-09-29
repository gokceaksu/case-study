package com.ty.casestudy;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {
	
	
	@Test
	public void addToCartTest() {
		
		SubCategory greenGroceryCategory = new SubCategory(CategoryEnum.GREEN_GROCERY);
		SubCategory laptopCategory = new SubCategory(CategoryEnum.LAPTOP);

		ShoppingCart cart = new ShoppingCart();

		Product apple = new Product("apple", 200.0, greenGroceryCategory);
		Product pear = new Product("pear", 100.0, greenGroceryCategory);
		Product vivobook = new Product("vivobook", 10000.0, laptopCategory);

		cart.addToCart(apple, 5);
		cart.addToCart(vivobook, 1);
		
		Assert.assertEquals(2, cart.getProducts().size());
		
		cart.addToCart(apple, 1);
		Assert.assertEquals(2, cart.getProducts().size());
		
		cart.addToCart(pear, 1);
		Assert.assertEquals(3, cart.getProducts().size());
	}

}
