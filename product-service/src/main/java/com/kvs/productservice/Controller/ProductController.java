package com.kvs.productservice.Controller;


import com.kvs.productservice.Dto.ProductRequestDTO;
import com.kvs.productservice.Dto.ProductResponseDTO;
import com.kvs.productservice.Service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Tag(name = "Product", description = "This API exposes endpoints to manage all products.")
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        productService.createProduct(productRequestDTO);
    }

    @GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}
