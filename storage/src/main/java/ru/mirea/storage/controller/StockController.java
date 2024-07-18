package ru.mirea.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.sdk.dto.storage.StockDto;
import ru.mirea.sdk.dto.storage.StorageDto;
import ru.mirea.storage.service.StockService;

import java.util.List;

@RestController
@RequestMapping({"/stock"})
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping({"/show"})
    public List<StockDto> showWorkers(@RequestBody(required = false) StockDto stockDto) {
        return this.stockService.getStocks(stockDto);
    }

    @PostMapping({"/add"})
    public StockDto addWorker(@RequestBody StockDto stockDto) {
        return this.stockService.saveStock(stockDto);
    }

    @PutMapping({"/edit"})
    public StockDto editWorker(@RequestBody StockDto stockDto) {
        return this.stockService.editStock(stockDto);
    }

    @DeleteMapping({"/remove"})
    public StockDto removeWorker(@RequestBody StorageDto stockDto) {
        return this.stockService.deleteStock(stockDto);
    }
}
