package ru.mirea.sdk.dto.storage;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.entity.storage.Storage;

import java.util.Map;
import java.util.UUID;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class StorageDto {
    private UUID id;
    private String name;
    private String address;
    private Map<String, String> info;

    public StorageDto(Storage value) {
        this.id = value.getId();
        this.name = value.getName();
        this.address = value.getAddress();
        this.info = value.getInfo();
    }
}
