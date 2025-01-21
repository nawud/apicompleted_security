package com.example.ecommerce_api.Product.service;

import com.example.ecommerce_api.Product.dto.ProductMapper;
import com.example.ecommerce_api.Product.dto.ProductRequest;
import com.example.ecommerce_api.Product.dto.ProductResponse;
import com.example.ecommerce_api.Product.model.Product;
import com.example.ecommerce_api.Product.repository.iProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final iProductRepository iProductRepository;

    public ProductService(iProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    // CREATE
    public ProductResponse addProduct(ProductRequest productRequest) {

        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = iProductRepository.save(newProduct);

        return ProductMapper.entityToDTO(savedProduct);

    }

    // READ
    public List<ProductResponse> getProducts() {

        List<Product> products = iProductRepository.findAll();

        if (products.isEmpty()) throw new RuntimeException("Not found");

        return products.stream().map(product -> ProductMapper.entityToDTO(product)).toList();

    }

    // UPDATE
    public ProductResponse updateProduct(long id, ProductRequest productRequest) {

        Optional<Product> foundProduct = iProductRepository.findById(id);

        if (foundProduct.isPresent()) {

            Product existingProduct = foundProduct.get();

            existingProduct.setPrice(productRequest.price());
            existingProduct.setName(productRequest.name());
            existingProduct.setImageURL(productRequest.imageURL());

            ProductResponse productResponse = ProductMapper.entityToDTO(existingProduct);

        } throw new RuntimeException("Product with id: " + id + " not found.");

    }

    // DELETE
    public void deleteProduct(long id) { iProductRepository.deleteById(id); }

    /* FILTERS */

    // ID
    public Optional<Product> findProductById(long id) { return iProductRepository.findById(id); }

}
