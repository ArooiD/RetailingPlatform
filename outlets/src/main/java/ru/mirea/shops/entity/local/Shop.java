package ru.mirea.shops.entity.local;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "outlet", name = "shop")
public class Shop {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "info")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> info;
    @Column(name = "store_id")
    private UUID store;
}
