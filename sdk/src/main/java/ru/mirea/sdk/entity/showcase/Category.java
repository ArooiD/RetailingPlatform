package ru.mirea.sdk.entity.showcase;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.dto.showcase.CategoryDto;

import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "showcase", name = "category")
@RequiredArgsConstructor
public class Category {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Category parent;

    Category(CategoryDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.parent = new Category(dto.getParent());
    }

}
