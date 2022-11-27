package com.order.product.error;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(long id) {
		super("Product id not found : " + id);
	}
}
