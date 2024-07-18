package ru.mirea.sdk.dto.outlets;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.dto.storage.StorageDto;
import ru.mirea.sdk.entity.outlets.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Setter
@Getter
@RequiredArgsConstructor
public class ShopDto {
    private UUID id;
    private String name;
    private String address;
    private Map<String, String> info;
    private List<StorageDto> storages;
    private List<StoreDto> stores;
    public ShopDto(Shop f) {
        this.id = f.getId();
        this.name = f.getName();
        this.address = f.getAddress();
        this.info = f.getInfo();
        this.storages = f.getStorage().stream().map(StorageDto::new).toList();
        this.stores = f.getStore().stream().map(StoreDto::new).toList();
    }
}
