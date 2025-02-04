package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.Product.ProductMapper;
import com.example.ecommerce_api.dto.Product.ProductRequest;
import com.example.ecommerce_api.dto.Product.ProductResponse;
import com.example.ecommerce_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/products")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {

        ProductResponse newProductResponse = productService.createProduct(productRequest);
        return new ResponseEntity<>(newProductResponse, HttpStatus.CREATED);

    }

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductResponse>> readAllProducts() {

        return new ResponseEntity<>(productService.readProducts(), HttpStatus.OK);

    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Optional<ProductResponse>> getProductById (@PathVariable long id) {

        Optional<ProductResponse> productResponse = productService.findProductById(id);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);

    }

    @PutMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable long id,
            @Valid @RequestBody ProductRequest productRequest
    ) {

        try {

            ProductResponse productResponse = ProductMapper.EntityToDTO(productService.updateProduct(id, productRequest));
            return new ResponseEntity<>(productResponse, HttpStatus.OK);

        } catch (RuntimeException e) { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }

    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable long id) {

        Optional<ProductResponse> productResponseOptional = productService.findProductById(id);

        if (productResponseOptional.isPresent()) { productService.deleteProduct(id); }

        return new ResponseEntity<>(HttpStatus.OK);

    }

}