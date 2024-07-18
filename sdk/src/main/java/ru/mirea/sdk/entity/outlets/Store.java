package ru.mirea.sdk.entity.outlets;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.dto.outlets.StoreDto;

import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "outlet", name = "store")
@RequiredArgsConstructor
public class Store {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;
    @Column(name = "name")
    private String name;
    @Column(name = "length")
    private int length;
    @Column(name = "width")
    private int width;
    @Column(name = "location")
    private String location;

    public Store(StoreDto dto){
        if(null != dto.getId()) {
            this.id = dto.getId();
        }
        this.name = dto.getName();
        this.length = dto.getLength();
        this.width = dto.getWidth();
        this.location = dto.getLocation();
    }
}
