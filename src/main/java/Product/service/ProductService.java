package Product.service;

import Product.dto.ProductMapper;
import Product.dto.ProductRequest;
import Product.dto.ProductResponse;
import Product.exceptions.EmptyException;
import Product.model.Product;
import Product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE
    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDTO(savedProduct);
    }

    // READ
    public List<ProductResponse> getProducts() {

        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) throw new EmptyException();

        return (List<ProductResponse>) products.stream().map(product -> ProductMapper.entityToDTO(product)).toList();

    }

}
