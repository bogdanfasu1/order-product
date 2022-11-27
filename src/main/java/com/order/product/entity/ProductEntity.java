package com.order.product.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	@Id
	@SequenceGenerator(name = "S_PRODUCT_0", sequenceName = "S_PRODUCT_0", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PRODUCT_0")
	@Column(name = "PRODUCT_NO")
	private long no;

	@Column(name = "NAME")
	@Size(max = 50)
	private String name;

	@Column(name = "DESCRIPTION")
	@Size(max = 200)
	private String description;

	@Column(name = "PRICE")
	private double price;
}
