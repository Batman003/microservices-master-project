package com.wajir.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wajir.productservice.dto.ProductRequest;
import com.wajir.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@Autowired
//	ProductRepository prodRepo;
//	@Container
//	static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:5"));
//
//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry registry){
//		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//	}
//	@Test
//	void shouldCreateProduct() throws Exception {
//		ProductRequest productRequest = getProductRequest();
//		String productRequestString = objectMapper.writeValueAsString(productRequest);
//
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(productRequestString))
//				.andExpect(status().isCreated());
//
//		Assertions.assertEquals(1,prodRepo.findAll().size());
//	}
//
//	@Test
//	void shouldGetProduct() throws Exception {
//		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/products")).andReturn();
//		System.out.println(mvcResult.getResponse());
//	}
//
//	private ProductRequest getProductRequest() {
//		return ProductRequest.builder()
//				.name("iphone 13")
//				.description("An iphone")
//				.price(BigDecimal.valueOf(120000))
//				.build();
//	}
//
//
//
//
}
