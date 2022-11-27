package com.order.product.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.product.api.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class OrderProductControllerTest {
	private static final String PATH = "/orders";
	private static final String PRODUCT_ID = "/1";
	private static final String NAME = "name";
	private static final String DESCRIPTION = "desc";
	private static final Double PRICE = 2.5;
	private ObjectMapper objectMapper;

	private MockMvc mockMvc;
	@InjectMocks
	private OrderProductController orderProductController;
	@Mock
	private ProductService service;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(orderProductController).build();
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	}

	@Test
	void getProductsTest() throws Exception {
		mockMvc.perform(get(PATH)
						.characterEncoding("UTF-8"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void getProductByIdTest() throws Exception {
		mockMvc.perform(get(PATH + PRODUCT_ID)
						.characterEncoding("UTF-8"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void deleteProductByIdTest() throws Exception {
		mockMvc.perform(delete(PATH + PRODUCT_ID)
						.characterEncoding("UTF-8"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void addProductTest() throws Exception {
		ProductDto productDto = getProductDto();
		mockMvc.perform(post(PATH)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(productDto)))
				.andExpect(status().is(204));
	}

	@Test
	public void addProduct_shouldReturnBadRequest() throws Exception {
		ProductDto productDto = getWrongProductDto();
		mockMvc.perform(post(PATH)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(productDto)))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void modifyProductTest() throws Exception {
		ProductDto productDto = getProductDto();
		mockMvc.perform(put(PATH + PRODUCT_ID)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(productDto)))
				.andExpect(status().isOk());
	}

	@Test
	public void modifyProduct_shouldReturnBadRequest() throws Exception {
		ProductDto productDto = getWrongProductDto();
		mockMvc.perform(put(PATH + PRODUCT_ID)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(productDto)))
				.andExpect(status().isBadRequest());
	}

	private ProductDto getProductDto() {
		return ProductDto.builder()
				.price(PRICE)
				.description(DESCRIPTION)
				.name(NAME)
				.build();
	}

	private ProductDto getWrongProductDto() {
		return ProductDto.builder()
				.price(PRICE)
				.name(NAME)
				.build();
	}
}