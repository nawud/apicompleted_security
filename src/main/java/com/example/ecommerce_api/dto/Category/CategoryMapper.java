package com.example.ecommerce_api.dto.Category;

import com.example.ecommerce_api.model.Category;

public class CategoryMapper {

    public static Category DTOToEntity (CategoryRequest categoryRequest) {

        return new Category (categoryRequest.name());

    }

    public static CategoryResponse EntityToDTO(Category category) {

        return new CategoryResponse(
                category.getId(),
                category.getName()
        );

    }

}