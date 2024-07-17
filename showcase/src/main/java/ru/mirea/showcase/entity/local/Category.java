package ru.mirea.showcase.entity.local;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "showcase", name = "category")
public class Category {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Category parent;
    @Version
    private int version;

}
