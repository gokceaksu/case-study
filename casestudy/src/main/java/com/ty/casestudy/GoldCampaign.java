package com.ty.casestudy;

public class GoldCampaign implements ICampaign {

	@Override
	public Double getProductPriceDiscount(Integer numProduct, Double productPrice) {

		if (numProduct >= 3) {
			return productPrice * 25 / 100;
		}
		return 0.0;
	}

}
