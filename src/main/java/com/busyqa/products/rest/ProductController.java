package com.busyqa.products.rest;

import com.busyqa.products.domain.Product;
import com.busyqa.products.rest.dto.ProductCreateDto;
import com.busyqa.products.rest.dto.ProductDto;
import com.busyqa.products.rest.dto.ProductDtoMapper;
import com.busyqa.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductDtoMapper productDtoMapper;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productDtoMapper.mapToDtos(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable long id) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isPresent()) {
            return productDtoMapper.mapToDto(product.get());
        }
        throw new RuntimeException("Product not found");
    }

    @PostMapping
    public void createProduct(@RequestBody ProductCreateDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setImageUrl(dto.getImageUrl());
        productService.save(product);
    }
}
