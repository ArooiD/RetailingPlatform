package ru.mirea.sdk.dto.showcase;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.entity.showcase.Category;

import java.util.UUID;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class CategoryDto {
    private UUID id;
    private String name;
    private CategoryDto parent;

    CategoryDto(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.parent = new CategoryDto(category.getParent());
    }
}
