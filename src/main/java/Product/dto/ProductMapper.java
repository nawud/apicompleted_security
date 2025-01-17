package Product.dto;

import Product.model.Product;

public class ProductMapper {

    public static Product dtoToEntity(ProductRequest productRequest) {
        return new Product (
                productRequest.price(),
                productRequest.name(),
                productRequest.imageURL()
        );
    }

}
