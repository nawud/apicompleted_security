package com.example.ecommerce_api.Product.service;

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
    public Product addProduct(Product newProduct) { return iProductRepository.save(newProduct); }

    // READ
    public List<Product> readProducts() { return iProductRepository.findAll(); }

    // UPDATE
    public Product updateProduct(long id, Product updatingProduct) {

        Optional<Product> foundProduct = iProductRepository.findById(id);

        if (foundProduct.isPresent()) {

            Product existingProduct = foundProduct.get();

            existingProduct.setPrice(updatingProduct.getPrice());
            existingProduct.setName(updatingProduct.getName());
            existingProduct.setImageURL(updatingProduct.getImageURL());

            return iProductRepository.save(existingProduct);

        } throw new RuntimeException("Product with id: " + id + " not found.");

    }

    // DELETE
    public void deleteProduct(long id) { iProductRepository.deleteById(id); }

    /* FILTERS */

    // ID
    public Optional<Product> findProductById(long id) { return iProductRepository.findById(id); }

}
