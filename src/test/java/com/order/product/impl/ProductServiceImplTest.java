package com.order.product.impl;

import com.order.product.api.dto.ProductDto;
import com.order.product.entity.ProductEntity;
import com.order.product.error.ProductNotFoundException;
import com.order.product.repository.ProductRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
	private static final String DESCRIPTION = "description";
	private static final Double PRICE = 13.0;
	private static final String NAME = "prodName";
	private static final long PRODUCT_ID = 1L;
	@InjectMocks
	private ProductServiceImpl service;
	@Mock
	private ProductRepository repository;

	@Test
	void givenExistingProductId_getProductById_shouldReturnProduct() {
		ProductEntity entity = getProductEntity();
		when(repository.findById(1L)).thenReturn(Optional.of(entity));

		val response = service.getProductById(1L);

		assertNotNull(response);
		assertEquals(DESCRIPTION, response.getDescription());
		assertEquals(PRICE, response.getPrice());
		assertEquals(NAME, response.getName());
	}

	@Test
	void givenNonExistingProductId_getProductById_shouldThrowProductNotFoundException() {
		when(repository.findById(1L)).thenReturn(Optional.empty());

		assertThrows(ProductNotFoundException.class, () -> service.getProductById(1L));
	}

	@Test
	void givenProductDto_addProduct_shouldSaveEntity() {
		ProductDto productDto = ProductDto.builder()
				.name(NAME)
				.description(DESCRIPTION)
				.price(PRICE)
				.build();

		service.addProduct(productDto);

		verify(repository).save(argThat(this::verifyEntity));
	}

	private boolean verifyEntity(ProductEntity entity) {
		assertEquals(NAME, entity.getName());
		assertEquals(DESCRIPTION, entity.getDescription());
		assertEquals(PRICE, Double.valueOf(entity.getPrice()));
		return true;
	}

	private static ProductEntity getProductEntity() {
		ProductEntity entity = new ProductEntity();
		entity.setPrice(PRICE);
		entity.setDescription(DESCRIPTION);
		entity.setName(NAME);
		return entity;
	}
}