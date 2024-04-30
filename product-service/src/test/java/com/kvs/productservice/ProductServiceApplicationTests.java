package com.kvs.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kvs.productservice.Dto.ProductRequestDTO;
import com.kvs.productservice.Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductRepository productRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception {

		ProductRequestDTO productRequestDTO = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequestDTO);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/product/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productRequestString)
		).andExpect(
                status().isCreated()
        );

        Assertions.assertEquals(1, productRepository.findAll().size());

	}

	@Test
	void shouldGetProductAndDeleteProduct() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/product/all")
						.contentType(MediaType.APPLICATION_JSON)
		).andExpect(
                status().isOk()
		);

		Assertions.assertEquals(1, productRepository.findAll().size());

		String productId = productRepository.findAll().get(0).getId();

		mockMvc.perform(
				MockMvcRequestBuilders.delete("/api/product/delete/" + productId)
						.contentType(MediaType.APPLICATION_JSON)
		).andExpect(
				status().isOk()
		);
	}

	private ProductRequestDTO getProductRequest() {
		return ProductRequestDTO.builder()
				.name("Product 1")
				.description("Product 1 description")
				.price(BigDecimal.valueOf(1200))
				.build();
	}

}
