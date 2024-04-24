package com.kvs.productservice.Service;


import com.kvs.productservice.Dto.ProductRequestDTO;
import com.kvs.productservice.Dto.ProductResponseDTO;
import com.kvs.productservice.Model.Product;
import com.kvs.productservice.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequestDTO productRequestDTO) {
        Product product = Product.builder()
                .name(productRequestDTO.getName())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product with name {} and id {} created successfully", product.getName(), product.getId());
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapProductToProductResponse).toList();
    }

    private ProductResponseDTO mapProductToProductResponse(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
