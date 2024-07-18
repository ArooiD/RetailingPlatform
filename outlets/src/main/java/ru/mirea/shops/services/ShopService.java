package ru.mirea.shops.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.dto.outlets.ShopDto;
import ru.mirea.sdk.entity.outlets.Shop;
import ru.mirea.shops.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    private final ShopRepository shopRepository;
    @Autowired
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopDto> getShop(ShopDto workerDto) {
        if (workerDto == null) {
            return this.shopRepository.findAll().stream().map(ShopDto::new).toList();
        } else if (workerDto.getId() != null) {
            Optional<Shop> optWorker = this.shopRepository.findById(workerDto.getId());
            return (List) optWorker.map((worker) -> {
                return List.of(new ShopDto(worker));
            }).orElseGet(() -> {
                return List.of(new ShopDto());
            });
        } else {
            throw new RuntimeException();
        }
    }
}
