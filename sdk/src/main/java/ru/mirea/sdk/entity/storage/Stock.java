package ru.mirea.sdk.entity.storage;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.mirea.sdk.dto.storage.StockDto;
import ru.mirea.sdk.entity.showcase.Product;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "storage", name = "stock")
public class Stock {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "storage_id", referencedColumnName = "id")
    private Storage storage;
    @Column(name = "count")
    private Integer count;
    @Column(name = "receipt_date")
    @JdbcTypeCode(SqlTypes.DATE)
    private Date receiptDate;

    public Stock(StockDto dto){
        if (dto.getId() != null) {
            this.id = dto.getId();
        }
        //this.name = dto.getName();
        this.count = dto.getCount();
    }

    public Stock() {}
}
