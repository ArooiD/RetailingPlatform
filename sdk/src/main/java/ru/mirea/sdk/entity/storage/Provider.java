package ru.mirea.sdk.entity.storage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.mirea.sdk.dto.storage.ProviderDto;

import java.util.Map;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "storage", name = "provider")
public class Provider {
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

    public Provider(ProviderDto dto) {
        if (dto.getId() != null) {
            id = dto.getId();
        }
        name = dto.getName();
        address = dto.getAddress();
        info = dto.getInfo();
    }

    public Provider() {

    }
}
