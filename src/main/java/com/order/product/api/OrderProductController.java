package com.order.product.api;

import com.order.product.api.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderProductController implements OrderProductManager {
	private final ProductService service;

	@Override
	public List<ProductDto> getProducts() {
		log.info("getProducts()");
		var productDtoList = service.getProducts();
		log.debug("getProducts() finished");
		return productDtoList;
	}

	@Override
	public void addProduct(ProductDto productDto) {
		log.info("addProduct({})", productDto);
		service.addProduct(productDto);
		log.debug("addProduct() finished");
	}

	@Override
	public ProductDto getProductById(Long productId) {
		log.info("getProductById({})", productId);
		var productDto = service.getProductById(productId);
		log.debug("getProductById() finished");
		return productDto;
	}

	@Override
	public void modifyProduct(ProductDto productDto, long productId) {
		log.info("modifyProduct({})", productDto);
		service.modifyProduct(productDto, productId);
		log.debug("modifyProduct() finished");
	}

	@Override
	public void deleteProduct(long productId) {
		log.info("deleteProduct({})", productId);
		service.deleteProduct(productId);
		log.debug("deleteProduct() finished");
	}
}
