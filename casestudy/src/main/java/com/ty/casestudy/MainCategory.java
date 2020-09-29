package com.ty.casestudy;

import java.util.ArrayList;

public class MainCategory extends Category {

	MainCategory(CategoryEnum title) {
		super(title);
		children = new ArrayList<>();
	}

	@Override
	public String showCategoryTree(String indentation) {

		String title = this.getTitle() + "\n";
		for (Category category : children) {

			title += indentation + category.showCategoryTree(indentation + " ");
		}

		title += "\n";
		return title;
	}
}
