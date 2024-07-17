package ru.mirea.shops.entity.local;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(schema = "outlet", name = "store")
public class Store {
    @Id
    private UUID id = UUID.randomUUID();
}
