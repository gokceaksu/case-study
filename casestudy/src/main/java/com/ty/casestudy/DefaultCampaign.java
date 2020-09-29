package com.ty.casestudy;

public class DefaultCampaign implements ICampaign {

	@Override
	public Double getProductPriceDiscount(Integer numProduct, Double productPrice) {

		if (numProduct >= 3) {
			return 10.0;
		}
		return 0.0;
	}

}
