package ru.mirea.storage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(schema = "storage", name = "storage")
public class Storage {
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
}
