package com.ty.casestudy;

public class Product {

	private String title;

	private Double price;

	private SubCategory category;
	

	public Product(String title, Double price, SubCategory category) {
		super();
		this.title = title;
		this.price = price;
		this.category = category;
	}
	

	/* Products with same title must have the same price and category */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;

		Product product = (Product) obj;

		return this.title.equals(product.title);
	}

	@Override
	public int hashCode() {
		return this.title.hashCode();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(SubCategory category) {
		this.category = category;
	}

}
