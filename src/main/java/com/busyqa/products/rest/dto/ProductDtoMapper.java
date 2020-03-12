package com.busyqa.products.rest.dto;

import com.busyqa.products.domain.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDtoMapper {

    public List<ProductDto> mapToDtos(List<Product> productList) {
        List<ProductDto> result = new ArrayList<>(productList.size());
        for (Product p : productList) {
            result.add(mapToDto(p));
        }
        return result;
    }

    public ProductDto mapToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategory(product.getCategory());
        dto.setImageUrl(product.getImageUrl());
        return dto;
    }
}
