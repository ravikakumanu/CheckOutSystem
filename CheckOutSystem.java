package com.checkout.shop.preinterview.java;

import java.util.List;

public class CheckOutSystem {
	private int appleCount;
	private int orangeCount;
	private double cost;

	

	/**
	 * this method accepts the list of items and calculate the total cost
	 * @param items
	 * @return
	 */
	public double performCheckout(List<String> items) {
		
		for (String item : items) {
			//String is immutable - so better create uppercase string only once and use multiple locations
			String productName=item.toUpperCase();
			try {
				if(productName.equals(ProductInfo.APPLE.name()))
				{
					appleCount= appleCount+1;
				}
				if(productName.equals(ProductInfo.ORANGE.name()))
				{
					orangeCount= orangeCount+1;
				}
				cost = cost + (ProductInfo.valueOf(productName)).showPrice();
			} catch (Exception e) {
				throw e;
			}
		}
		if(items!=null && items.size()>0)
		{
		caliculateDiscountCost();
		}
		return cost;
	}


	private void caliculateDiscountCost() {
		double discountCost=0.00;
		OfferDetails offer = new OfferDetails();
		settingOffers(offer);
		discountCost = (appleCount/offer.getAppleOffer())*ProductInfo.APPLE.showPrice() +
				(orangeCount/offer.getOrangeOffer())*ProductInfo.ORANGE.showPrice();
		cost=cost-discountCost;
	}

	/**
	 * In real time offers can be set from business rules
	 * @param offer
	 */

	private void settingOffers(OfferDetails offer) {
		//cost for every second apple is free
		offer.setAppleOffer(2);
		//cost for every third orange is free
		offer.setOrangeOffer(3);
	}
}
