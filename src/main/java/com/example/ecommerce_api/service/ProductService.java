package com.example.ecommerce_api.service;

import com.example.ecommerce_api.dto.Product.ProductMapper;
import com.example.ecommerce_api.dto.Product.ProductRequest;
import com.example.ecommerce_api.dto.Product.ProductResponse;
import com.example.ecommerce_api.exceptions.EmptyException;
import com.example.ecommerce_api.exceptions.ObjectNotFoundException;
import com.example.ecommerce_api.model.Product;
import com.example.ecommerce_api.repository.iProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final iProductRepository iProductRepository;

    public ProductService (iProductRepository iProductRepository) {

        this.iProductRepository = iProductRepository;

    }

    public ProductResponse createProduct (ProductRequest productRequest) {

        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = iProductRepository.save(newProduct);

        return ProductMapper.entityToDTO(savedProduct);

    }

    public List<ProductResponse> readProducts() {

        List<Product> products = iProductRepository.findAll();

        if (products.isEmpty()) throw new EmptyException();

        return products.stream().map(ProductMapper::entityToDTO).toList();

    }

    public Product updateProduct (long id, ProductRequest productRequest) {

        Optional<Product> foundProduct = iProductRepository.findById(id);

        if (foundProduct.isPresent()) {

            Product existingProduct = foundProduct.get();

            existingProduct.setPrice(productRequest.price());
            existingProduct.setName(productRequest.name());
            existingProduct.setImageURL(productRequest.imageURL());

            return iProductRepository.save(existingProduct);

        } throw new ObjectNotFoundException(productRequest.name(), id);

    }

    public void deleteProduct (long id) { iProductRepository.deleteById(id); }

}
