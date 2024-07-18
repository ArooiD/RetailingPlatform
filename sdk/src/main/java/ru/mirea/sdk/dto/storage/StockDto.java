package ru.mirea.sdk.dto.storage;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.entity.storage.Stock;
import ru.mirea.sdk.entity.storage.Storage;

import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class StockDto {
    private UUID id;
    private UUID product;
    private Storage storage;
    private Integer count;
    private Date receiptDate;

    public StockDto(Stock stock) {
        this.id = stock.getId();
        this.product = stock.getProduct().getId();
        this.storage = stock.getStorage();
        this.count = stock.getCount();
        this.receiptDate = stock.getReceiptDate();
    }
}
