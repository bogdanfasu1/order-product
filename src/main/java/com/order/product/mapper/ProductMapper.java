package com.order.product.mapper;

import com.order.product.api.dto.ProductDto;
import com.order.product.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public static ProductEntity productDtoToEntity(ProductDto productDto) {
		ProductEntity entity = new ProductEntity();
		entity.setName(productDto.getName());
		entity.setDescription(productDto.getDescription());
		entity.setPrice(productDto.getPrice());
		return entity;
	}

	public static ProductDto entityToProductDto(ProductEntity entity) {
		ProductDto productDto = new ProductDto();
		productDto.setId(entity.getNo());
		productDto.setName(entity.getName());
		productDto.setDescription(entity.getDescription());
		productDto.setPrice(entity.getPrice());
		return productDto;
	}
}
