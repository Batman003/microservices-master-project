package com.wajir.productservice.controller;

import com.wajir.productservice.dto.ProductRequest;
import com.wajir.productservice.dto.ProductResponse;
import com.wajir.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@Slf4j
public class ProductController {


    private final ProductService prodService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProducts(@RequestBody ProductRequest productRequest){
        prodService.createProduct(productRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        List<ProductResponse> products = prodService.getAllProduct();
        return products;
    }
}
