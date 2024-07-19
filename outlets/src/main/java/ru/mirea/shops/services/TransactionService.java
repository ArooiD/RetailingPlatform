package ru.mirea.shops.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.dto.outlets.TransactionDto;
import ru.mirea.sdk.entity.outlets.Transaction;
import ru.mirea.shops.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionService(TransactionRepository transaction) {
        this.transactionRepository = transaction;
    }

    public List<TransactionDto> getTransaction(TransactionDto transactionDto){
        if (transactionDto == null) {
            return transactionRepository.findAll().stream().map(TransactionDto::new).toList();
        } else {
            if (transactionDto.getId() != null) {
                Optional<Transaction> optShop= transactionRepository.findById(transactionDto.getId());
                return optShop.map(t -> List.of(new TransactionDto(t))).orElseGet(() -> List.of(new TransactionDto()));
            } else {
                throw new RuntimeException();
            }
        }
    }

    public TransactionDto saveTransaction(TransactionDto TransactionDto) {
        return new TransactionDto(transactionRepository.save(new Transaction(TransactionDto)));
    }

    // Что тут делать, у нас так то один ID и есть в public class Store
    public TransactionDto editTransaction(TransactionDto transactionDto) {
        Transaction w = new Transaction(transactionDto);
        Optional<Transaction> v  = transactionRepository.findById(transactionDto.getId());
        if(v.isPresent()){
            Transaction worker = v.get();
            w = worker;
        }
        return saveTransaction(new TransactionDto(w));
    }

    public TransactionDto deleteTransaction(TransactionDto dto){
        AtomicReference<Transaction> w = new AtomicReference<>();
        transactionRepository.findById(dto.getId()).ifPresent(
                store -> {
                    w.set(store);
                    transactionRepository.deleteById(dto.getId());
                }
        );
        return new TransactionDto(w.get());
    }
}
