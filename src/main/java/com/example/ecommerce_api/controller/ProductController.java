package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.Category.CategoryRequest;
import com.example.ecommerce_api.dto.Product.ProductRequest;
import com.example.ecommerce_api.dto.Product.ProductResponse;
import com.example.ecommerce_api.model.Product;
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
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest productRequest) {

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

        if (productResponse.isPresent()) {

            return new ResponseEntity<>(productResponse, HttpStatus.OK);

        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable long id,
            @Valid @RequestBody ProductRequest productRequest
    ) {

        try {

            productService.updateProduct(id, productRequest);

        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } return  new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable long id) {

        try { productService.deleteProduct(id); } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/api/products/{categoryName}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(
            @RequestParam long id,
            String categoryName,
            List<Product> products
    ) {

        CategoryRequest categoryRequest = new CategoryRequest(id, categoryName);
        List<ProductResponse> productResponseList = productService.getProductsByCategory(categoryRequest, id);
        return new ResponseEntity<>(productResponseList, HttpStatus.OK);

    }

}