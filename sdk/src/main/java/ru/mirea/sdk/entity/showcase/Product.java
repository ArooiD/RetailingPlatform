package ru.mirea.sdk.entity.showcase;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.mirea.sdk.dto.showcase.ProductDto;

import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "showcase", name = "product")
public class Product {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "image")
    private String image;
    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @Column(name = "available")
    private Boolean available;
    public Product(){}
    public Product(ProductDto product) {

    }
}
