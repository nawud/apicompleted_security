package Product.controller;

import Product.dto.ProductRequest;
import Product.dto.ProductResponse;
import Product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.saveProduct(productRequest), HttpStatus.CREATED);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

}
