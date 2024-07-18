package ru.mirea.sdk.entity.showcase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "showcase", name = "brand")
@RequiredArgsConstructor
public class Brand {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @Column(name = "name")
    private String name;
    @Column(name = "logo")
    private String logo;
}
