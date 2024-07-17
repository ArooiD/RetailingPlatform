package ru.mirea.storage.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "storage", name = "stock")
public class Stock {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "product_id")
    private UUID product;

    @ManyToOne
    @JoinColumn(name = "storage_id", referencedColumnName = "id")
    private Storage storage;

    @Column(name = "count")
    private String name;

    @Column(name = "receipt_date")
    @JdbcTypeCode(SqlTypes.DATE)
    private Date receiptDate;
}
