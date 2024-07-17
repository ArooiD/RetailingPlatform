package ru.mirea.shops.entity.local;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(schema = "outlet", name = "transaction")
public class Transaction {
    @Id
    private UUID id = UUID.randomUUID();
}
