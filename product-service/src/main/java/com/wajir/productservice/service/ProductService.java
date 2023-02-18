package com.wajir.productservice.service;

import com.wajir.productservice.dto.ProductRequest;
import com.wajir.productservice.dto.ProductResponse;
import com.wajir.productservice.model.Product;
import com.wajir.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository prodRepo;
    public void createProduct(ProductRequest prodRequest){
        Product product = Product.builder()
                .name(prodRequest.getName())
                .description(prodRequest.getDescription())
                .price(prodRequest.getPrice()).build();

        prodRepo.save(product);
        log.info("Product {} is saved", product.getId());
        
    }

    public List<ProductResponse> getAllProduct() {
        List<Product> products = prodRepo.findAll();
        log.info("All products : {}",products);
        return products
                .stream()
                .map(this::mapToProductResponse)
                .toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
