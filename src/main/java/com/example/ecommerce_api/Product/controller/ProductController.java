package com.example.ecommerce_api.Product.controller;

import com.example.ecommerce_api.Product.dto.ProductRequest;
import com.example.ecommerce_api.Product.dto.ProductResponse;
import com.example.ecommerce_api.Product.model.Product;
import com.example.ecommerce_api.Product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    // CREATE
    @PostMapping()
    public void createProduct(@RequestBody Product newProduct) { productService.addProduct(newProduct); }

    // READ
    @GetMapping()
    public List<Product> readAllProducts() { return productService.readProducts(); }

    // UPDATE
    @PutMapping()
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product updatingProduct) {

        try {

            Product product = productService.updateProduct(id, updatingProduct);
            return new ResponseEntity<>(product, HttpStatus.ACCEPTED);

        } catch (Exception e) { return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); }

    }

    // DELETE
    @PostMapping
    public void deleteProduct(@PathVariable long id) { productService.deleteProduct(id); }

    /* FILTERS */

    // ID
    @GetMapping("")
    public ResponseEntity<Product> findProductById(@PathVariable long id) {

        Optional<Product> foundProduct = productService.findProductById(id);

        if (foundProduct.isPresent()) { return new ResponseEntity<>(foundProduct.get(), HttpStatus.FOUND); }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
