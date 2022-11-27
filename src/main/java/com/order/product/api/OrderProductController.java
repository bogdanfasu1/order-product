package com.order.product.api;

import com.order.product.api.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderProductController implements OrderProductManager {
	private final ProductService service;

	@Override
	public List<ProductDto> getProducts() {
		return service.getProducts();
	}

	@Override
	public void addProduct(ProductDto productDto) {
		service.addProduct(productDto);
	}

}
