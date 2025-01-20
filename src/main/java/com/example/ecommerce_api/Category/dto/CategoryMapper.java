package com.example.ecommerce_api.Category.dto;

import com.example.ecommerce_api.Category.model.Category;
import com.example.ecommerce_api.User.dto.UserRequest;
import com.example.ecommerce_api.User.dto.UserResponse;
import com.example.ecommerce_api.User.model.User;

public class CategoryMapper {

    public static Category DTOToEntity(CategoryRequest categoryRequest) { return new Category(categoryRequest.username()); }

    public static CategoryResponse EntityToDTO(Category category) { return new CategoryResponse(category.getName()); }

    }

}
