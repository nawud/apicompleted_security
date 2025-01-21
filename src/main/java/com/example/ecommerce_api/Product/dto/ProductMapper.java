package com.example.ecommerce_api.Product.dto;

import com.example.ecommerce_api.Product.model.Product;

public class ProductMapper {

    public static Product dtoToEntity(ProductRequest productRequest) {
        return new Product (
                productRequest.price(),
                productRequest.name(),
                productRequest.imageURL()
        );
    }

    public static ProductResponse entityToDTO(Product product) {
        return new ProductResponse (
                product.
                product.getName(),
                product.getImageURL()
        );
    }

}
