package com.example.ecommerce_api.dto.Product;

import com.example.ecommerce_api.model.Product;

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
                product.getId(),
                product.getPrice(),
                product.getName(),
                product.getImageURL(),
                product.getCategory()

        );

    }

}
