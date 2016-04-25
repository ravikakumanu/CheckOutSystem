package com.checkout.shop.preinterview.java;

import java.util.List;

public class CheckOutSystem {

	/**
	 * this method accepts the list of items and calculate the total cost
	 * @param items
	 * @return
	 */
	public double performCheckout(List<String> items) {
		double cost = 0.00;
		for (String item : items) {
			try {
				cost = cost + (ProductInfo.valueOf(item.toUpperCase())).showPrice();
			} catch (Exception e) {
				throw e;
			}
		}
		return cost;
	}
}
