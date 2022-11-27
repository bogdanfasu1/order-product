package com.order.product.api.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private long id;
	@NotNull(message = "name has to be present")
	private String name;
	@NotNull(message = "description has to be present")
	private String description;
	@NotNull(message = "price has to be present")
	private Double price;
}
