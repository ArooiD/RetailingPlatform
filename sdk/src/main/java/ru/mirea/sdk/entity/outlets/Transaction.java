package ru.mirea.sdk.entity.outlets;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.dto.outlets.TransactionDto;
import ru.mirea.sdk.entity.showcase.Product;
import ru.mirea.sdk.entity.web.User;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "outlet", name = "transaction")
@RequiredArgsConstructor
public class Transaction {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @Column(name = "count")
    private Integer count;
    @Column(name = "timestamp")
    private Date timestamp;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    public Transaction(TransactionDto dto){
        if(dto.getId() != null) {
            this.id = dto.getId();
        }
        this.store = new Store(dto.getStore());
        this.product = new Product(dto.getProduct());
        this.count = dto.getCount();
        this.timestamp = dto.getTimestamp();
        this.user = new User(dto.getUser());
    }
}
