package com.order.product.api;

import com.order.product.api.dto.ProductDto;

import java.util.List;

public interface ProductService {

	List<ProductDto> getProducts();

	void addProduct(ProductDto productDto);

	ProductDto getProductById(Long productId);
}
