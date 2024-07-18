package ru.mirea.sdk.entity.outlets;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.mirea.sdk.dto.outlets.ShopDto;
import ru.mirea.sdk.entity.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "outlet", name = "shop")
@RequiredArgsConstructor
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
    @ManyToMany
    @JoinTable(schema = "link", name = "shop_storage",
            joinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "storage_id", referencedColumnName = "id"))
    private List<Storage> storage = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private List<Store> store = new ArrayList<>();

    public Shop(ShopDto shop) {
        this.id = shop.getId();
        this.name = shop.getName();
        this.info = shop.getInfo();
        this.address = shop.getAddress();
        this.storage = shop.getStorages().stream().map(Storage::new).toList();
        this.store = shop.getStores().stream().map(Store::new).toList();
    }

}
