package ru.mirea.sdk.dto.outlets;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.entity.outlets.Shop;
import ru.mirea.sdk.entity.outlets.Store;

import java.util.UUID;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class StoreDto {
    private UUID id;
    private ShopDto shop;
    private String name;
    private int length;
    private int width;
    private String location;
    public StoreDto(Store store) {
        this.id = store.getId();
        this.shop = new ShopDto(store.getShop());
        this.name = store.getName();
        this.length = store.getLength();
        this.width = store.getWidth();
        this.location = store.getLocation();
    }
}
