package com.order.product.impl;

import com.order.product.api.ProductService;
import com.order.product.api.dto.ProductDto;
import com.order.product.mapper.ProductMapper;
import com.order.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository repository;

	@Override
	public List<ProductDto> getProducts() {
		return repository.findAll()
				.stream()
				.map(ProductMapper::entityToProductDto)
				.collect(Collectors.toList());
	}

	@Override
	public void addProduct(ProductDto productDto) {
		val entity = ProductMapper.productDtoToEntity(productDto);
		repository.save(entity);
	}
}