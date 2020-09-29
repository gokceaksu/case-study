package com.ty.casestudy;

public class SubCategory extends Category {

	SubCategory(CategoryEnum title) {
		super(title);
	}

	@Override
	public String showCategoryTree(String indentation) {
		return this.getTitle().toString();
	}
}
