package com.checkout.shop.preinterview.java;

public enum ProductInfo {
	APPLE(0.60), ORANGE(0.25);

	double price;

	ProductInfo(double p) {
		price = p;
	}

	double showPrice() {
		return price;
	}
}
