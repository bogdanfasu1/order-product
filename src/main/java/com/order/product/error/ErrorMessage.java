package com.order.product.error;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ErrorMessage {
	private UUID id = UUID.randomUUID();
	private String message;

	public ErrorMessage(String message) {
		this.message = message;
	}

}
