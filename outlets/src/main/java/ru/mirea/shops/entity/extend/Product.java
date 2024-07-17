package ru.mirea.shops.entity.extend;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
import java.util.function.DoubleBinaryOperator;

@Entity
@Data
@Getter
@Setter
@Table(schema = "showcase", name = "product")
public class Product {
    @Id
    @Column(name = "id")
    private UUID id;
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
}
