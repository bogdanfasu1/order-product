package com.order.product.api;

import com.order.product.api.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/orders")
public interface OrderProductManager {

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	List<ProductDto> getProducts();

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@PostMapping
	void addProduct(@RequestBody @Valid ProductDto productDto);

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	ProductDto getProductById(@PathVariable Long productId);

	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping(path = "/{productId}")
	void modifyProduct(@Valid @RequestBody ProductDto productDto, @PathVariable long productId);

	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping(path = "/{productId}")
	void deleteProduct(@PathVariable long productId);
}
