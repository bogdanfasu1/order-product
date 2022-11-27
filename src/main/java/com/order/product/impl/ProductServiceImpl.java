package com.order.product.impl;

import com.order.product.api.ProductService;
import com.order.product.api.dto.ProductDto;
import com.order.product.error.ProductNotFoundException;
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

	@Override
	public ProductDto getProductById(Long productId) {
		return repository.findById(productId)
				.map(ProductMapper::entityToProductDto)
				.orElseThrow(() -> new ProductNotFoundException(productId));
	}

	@Override
	public void modifyProduct(ProductDto productDto, long productId) {
		val entity = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
		entity.setName(productDto.getName());
		entity.setDescription(productDto.getDescription());
		entity.setPrice(productDto.getPrice());
		repository.save(entity);
	}

}
