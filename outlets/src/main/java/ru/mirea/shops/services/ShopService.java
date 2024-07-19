package ru.mirea.shops.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.dto.outlets.ShopDto;
import ru.mirea.sdk.entity.outlets.Shop;
import ru.mirea.sdk.entity.outlets.Store;
import ru.mirea.shops.repository.ShopRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    @Autowired
    public ShopService(ShopRepository shop) {
        this.shopRepository = shop;
    }

    public List<ShopDto> getShop(ShopDto shopDto){
        if (shopDto == null) {
            return shopRepository.findAll().stream().map(ShopDto::new).toList();
        } else {
            if (shopDto.getId() != null) {
                Optional<Shop> optShop= shopRepository.findById(shopDto.getId());
                return optShop.map(shop -> List.of(new ShopDto(shop))).orElseGet(() -> List.of(new ShopDto()));
            } else {
                throw new RuntimeException();
            }
        }
    }

    public ShopDto saveShop(ShopDto shopDto) {
        return new ShopDto(shopRepository.save(new Shop(shopDto)));
    }

    public ShopDto editShop(ShopDto workerDto) {
        Shop w = new Shop(workerDto);
        Optional<Shop> v  = shopRepository.findById(workerDto.getId());
        if(v.isPresent()){
            Shop worker = v.get();
            if(workerDto.getName() != null) {
                worker.setName(workerDto.getName());
            }
            if(workerDto.getAddress() != null) {
                worker.setAddress(workerDto.getAddress());
            }
            if(workerDto.getInfo() != null) {
                worker.setInfo(workerDto.getInfo());
            }
            if(workerDto.getStores() != null) {
                worker.setStore(workerDto.getStores().stream().map(Store::new).toList());
            }
            w = worker;
        }
        return saveShop(new ShopDto(w));
    }

    public ShopDto deleteShop(ShopDto dto){
        AtomicReference<Shop> w = new AtomicReference<>();
        shopRepository.findById(dto.getId()).ifPresent(
                shop -> {
                    w.set(shop);
                    shopRepository.deleteById(dto.getId());
                }
        );
        return new ShopDto(w.get());
    }
}
