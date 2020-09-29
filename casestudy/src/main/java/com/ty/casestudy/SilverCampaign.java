package com.ty.casestudy;

public class SilverCampaign implements ICampaign {

	@Override
	public Double getProductPriceDiscount(Integer numProduct, Double productPrice) {
		if (numProduct >= 3) {
			return productPrice * 10 / 100;
		}
		return 0.0;
	}

}
