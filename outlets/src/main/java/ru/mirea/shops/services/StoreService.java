package ru.mirea.shops.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.dto.outlets.StoreDto;
import ru.mirea.sdk.entity.outlets.Store;
import ru.mirea.shops.repository.StoreRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    @Autowired
    public StoreService(StoreRepository store) {
        this.storeRepository = store;
    }

    public List<StoreDto> getShop(StoreDto storeDto){
        if (storeDto == null) {
            return storeRepository.findAll().stream().map(StoreDto::new).toList();
        } else {
            if (storeDto.getId() != null) {
                Optional<Store> optStore = storeRepository.findById(storeDto.getId());
                return optStore.map(store -> List.of(new StoreDto(store))).orElseGet(() -> List.of(new StoreDto()));
            } else {
                throw new RuntimeException();
            }
        }
    }

    public StoreDto saveStore(StoreDto storeDto) {
        return new StoreDto(storeRepository.save(new Store(storeDto)));
    }

    // Что тут делать, у нас так то один ID и есть в public class Store
    public StoreDto editStore(StoreDto storeDto) {
        Store w = new Store(storeDto);
        Optional<Store> v  = storeRepository.findById(storeDto.getId());
        if(v.isPresent()){
            Store worker = v.get();
            w = worker;
        }
        return saveStore(new StoreDto(w));
    }

    public StoreDto deleteStore(StoreDto dto){
        AtomicReference<Store> w = new AtomicReference<>();
        storeRepository.findById(dto.getId()).ifPresent(
                store -> {
                    w.set(store);
                    storeRepository.deleteById(dto.getId());
                }
        );
        return new StoreDto(w.get());
    }
}
