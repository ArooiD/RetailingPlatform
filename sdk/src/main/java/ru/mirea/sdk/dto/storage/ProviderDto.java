package ru.mirea.sdk.dto.storage;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.entity.storage.Provider;

import java.util.Map;
import java.util.UUID;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class ProviderDto {
    private UUID id;
    private String name;
    private String address;
    private Map<String, String> info;
    public ProviderDto(Provider provider) {
        this.id = provider.getId();
        this.name = provider.getName();
        this.info = provider.getInfo();
        this.address = provider.getAddress();
    }
}
