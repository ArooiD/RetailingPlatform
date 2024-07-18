package ru.mirea.sdk.dto.showcase;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.entity.showcase.Category;
import ru.mirea.sdk.entity.showcase.Product;

import java.util.UUID;

@Data
@Setter
@Getter
@RequiredArgsConstructor
public class ProductDto {
    private UUID id;
    private String name;
    private String description;
    private Double cost;
    private String image;
    private CategoryDto category;
    private Boolean available;
    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.cost = product.getCost();
        this.image = product.getImage();
        this.category = new CategoryDto(product.getCategory());
        this.available = product.getAvailable();
    }
}
