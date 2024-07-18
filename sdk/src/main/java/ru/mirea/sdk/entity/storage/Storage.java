package ru.mirea.sdk.entity.storage;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.mirea.sdk.dto.outlets.StoreDto;
import ru.mirea.sdk.dto.storage.StorageDto;
import ru.mirea.sdk.entity.outlets.Shop;

import java.util.List;
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

    @ManyToMany
    @JoinTable(schema = "link", name = "shop_storage",
            joinColumns = @JoinColumn(name = "storage_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id"))
    private List<Shop> shops;

    public Storage(StorageDto storageDto) {

    }

    public Storage() {
    }
}
