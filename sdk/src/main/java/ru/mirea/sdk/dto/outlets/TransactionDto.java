package ru.mirea.sdk.dto.outlets;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.dto.showcase.ProductDto;
import ru.mirea.sdk.dto.web.UserDto;
import ru.mirea.sdk.entity.outlets.Store;
import ru.mirea.sdk.entity.outlets.Transaction;
import ru.mirea.sdk.entity.showcase.Product;

import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class TransactionDto {
    private UUID id;
    private StoreDto store;
    private ProductDto product;
    private Integer count;
    private Date timestamp;
    private UserDto user;
    public TransactionDto(Transaction transaction){
        this.id = transaction.getId();
        this.store = new StoreDto(transaction.getStore());
        this.product = new ProductDto(transaction.getProduct());
        this.count = transaction.getCount();
        this.timestamp = transaction.getTimestamp();
        this.user = new UserDto(transaction.getUser());
    }
}
