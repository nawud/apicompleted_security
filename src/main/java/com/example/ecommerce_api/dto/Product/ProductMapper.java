package com.example.ecommerce_api.dto.Product;

import com.example.ecommerce_api.dto.Category.CategoryMapper;
import com.example.ecommerce_api.model.Category;
import com.example.ecommerce_api.model.Product;
import com.example.ecommerce_api.repository.iCategoryRepository;
import java.util.Optional;

public class ProductMapper {

    public static Product dtoToEntity(
            ProductRequest productRequest,
            iCategoryRepository iCategoryRepository
    ) {

        Optional<Category> category = iCategoryRepository.findById(productRequest.categoryId());

        return new Product (
                productRequest.name(),
                productRequest.price(),
                productRequest.imageURL(),
                category
        );

    }

    public static ProductResponse entityToDTO(Product product) {

        return new ProductResponse (
                product.getId(),
                product.getPrice(),
                product.getName(),
                product.getImageURL(),
                CategoryMapper.EntityToDTO(product.getCategory()).id()
        );

    }

}