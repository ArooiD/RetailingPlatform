package ru.mirea.shops.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.sdk.dto.outlets.TransactionDto;
import ru.mirea.shops.services.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/show")
    public List<TransactionDto> showTransaction(@RequestBody(required = false) TransactionDto transactionDto) {
        return transactionService.getTransaction(transactionDto);
    }

    @PostMapping("/add")
    public TransactionDto addTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.saveTransaction(transactionDto);
    }

    @PutMapping("/edit")
    public TransactionDto editTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.editTransaction(transactionDto);
    }

    @DeleteMapping ("/remove")
    public TransactionDto removeTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.deleteTransaction(transactionDto);
    }
}
