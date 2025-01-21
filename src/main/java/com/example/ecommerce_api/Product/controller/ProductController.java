package com.example.ecommerce_api.Product.controller;

import com.example.ecommerce_api.Product.dto.ProductMapper;
import com.example.ecommerce_api.Product.dto.ProductRequest;
import com.example.ecommerce_api.Product.dto.ProductResponse;
import com.example.ecommerce_api.Product.model.Product;
import com.example.ecommerce_api.Product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE
    @PostMapping("/api/products")
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductRequest productRequest) {

        ProductResponse newProductResponse = productService.addProduct(productRequest);
        return new ResponseEntity<>(newProductResponse, HttpStatus.CREATED);

    }

    // READ
    @GetMapping("/api/products")
    public ResponseEntity<List<ProductResponse>> getProducts() {

        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);

    }

}


   /*
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        Product product = productService.addProduct(ProductMapper.dtoToEntity(request));
        return new ResponseEntity<>(ProductMapper.entityToDTO(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.readProducts()
                .stream()
                .map(ProductMapper::entityToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id) {
        return productService.findProductById(id)
                .map(product -> ResponseEntity.ok(ProductMapper.entityToDTO(product)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable long id,
            @Valid @RequestBody ProductRequest request) {
        try {
            Product product = productService.updateProduct(id, ProductMapper.dtoToEntity(request));
            return ResponseEntity.ok(ProductMapper.entityToDTO(product));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
    */