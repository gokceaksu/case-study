package com.ty.casestudy;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {

	
	private CategoryEnum title;

	private Category parent;

	protected List<Category> children;

	private List<ICampaign> campaignList;
	
	
	Category(CategoryEnum title) {
		this.title = title;
		this.campaignList = new ArrayList<>();
	}

	public CategoryEnum getTitle() {
		return title;
	}

	public void setTitle(CategoryEnum title) {
		this.title = title;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<ICampaign> getCampaignList() {
		return this.campaignList;
	}

	public void addCampaign(ICampaign campaign) {
		getCampaignList().add(campaign);
	}

	private Boolean hasCampaign() {
		return !getCampaignList().isEmpty() ? true : false;
	}

	public void addChild(Category category) {
		children.add(category);
		category.setParent(this);
	}

	public List<Category> getChildren() {
		return this.children;
	}

	public Boolean hasChildren() {
		return getChildren() != null && !getChildren().isEmpty() ? true : false;
	}

	public Double getTotalDiscountAmountOfCategory(Integer numProduct, Double productPrice) {

		Double result = calculateCampaignListTotalDiscount(numProduct, productPrice, getCampaignList());

		/* Parent categories may have campaigns */
		Category tempParent = getParent();
		while (tempParent != null) {
			result += calculateCampaignListTotalDiscount(numProduct, productPrice, tempParent.getCampaignList());
			tempParent = tempParent.getParent();
		}

		return result;
	}

	private Double calculateCampaignListTotalDiscount(Integer numProduct, Double productPrice,
			List<ICampaign> campaignList) {
		Double result = 0.0;
		if (hasCampaign() != null) {
			for (ICampaign iCampaign : campaignList) {
				result += iCampaign.getProductPriceDiscount(numProduct, productPrice);
			}
		}
		return result;
	}

	/* Just to check our tree */
	public abstract String showCategoryTree(String indentation);

}
