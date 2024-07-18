package ru.mirea.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.dto.storage.StockDto;
import ru.mirea.sdk.dto.storage.StorageDto;
import ru.mirea.sdk.entity.storage.Stock;
import ru.mirea.storage.repository.StockRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StockService {
    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<StockDto> getStocks(StockDto stockDto) {
        if (stockDto == null) {
            return this.stockRepository.findAll().stream().map(stock -> new StockDto()).toList();
        } else if (stockDto.getId() != null) {
            Optional<Stock> stock = this.stockRepository.findById(stockDto.getId());
            return stock.map(worker -> List.of(new StockDto())).orElseGet(() -> List.of(new StockDto()));
        } else {
            throw new RuntimeException("No worker found");
        }
    }

    public StockDto saveStock(StockDto dto) {
        return new StockDto();
    }

    public StockDto deleteStock(StorageDto dto) {
        AtomicReference<Stock> w = new AtomicReference<>();
        this.stockRepository.findById(dto.getId()).ifPresent((worker) -> {
            w.set(worker);
            this.stockRepository.deleteById(dto.getId());
        });
        return new StockDto();
    }

    public StockDto editStock(StockDto stockDto) {
        Stock w = new Stock(stockDto);
        Optional<Stock> v = this.stockRepository.findById(stockDto.getId());
        if (v.isPresent()) {
            Stock worker = (Stock) v.get();

            //if (stockDto.getProduct() != null) {
            //    worker.setProduct(stockDto.getProduct());
            //}

            if (stockDto.getStorage() != null) {
                worker.setStorage(stockDto.getStorage());
            }

            if (stockDto.getReceiptDate() != null) {
                worker.setReceiptDate(stockDto.getReceiptDate());
            }
            w = worker;
        }
        return this.saveStock(new StockDto());
    }
}
