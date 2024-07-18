package ru.mirea.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.dto.storage.StorageDto;
import ru.mirea.sdk.entity.storage.Storage;
import ru.mirea.storage.repository.StorageRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StorageService {
    private final StorageRepository storageRepository;

    @Autowired
    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public List<StorageDto> getStorages(StorageDto storageDto) {
        if (storageDto == null) {
            return this.storageRepository.findAll().stream().map(StorageDto::new).toList();
        } else if (storageDto.getId() != null) {
            Optional<Storage> storage = this.storageRepository.findById(storageDto.getId());
            return storage.map(worker -> List.of(new StorageDto(worker))).orElseGet(() -> List.of(new StorageDto()));
        } else {
            throw new RuntimeException("No worker found");
        }
    }

    public StorageDto saveStorage(StorageDto dto) {
        return new StorageDto((Storage) this.storageRepository.save(new Storage(dto)));
    }

    public StorageDto deleteStorage(StorageDto dto) {
        AtomicReference<Storage> w = new AtomicReference();
        this.storageRepository.findById(dto.getId()).ifPresent((worker) -> {
            w.set(worker);
            this.storageRepository.deleteById(dto.getId());
        });
        return new StorageDto((Storage) w.get());
    }

    public StorageDto editStorage(StorageDto storageDto) {
        Storage w = new Storage(storageDto);
        Optional<Storage> v = this.storageRepository.findById(storageDto.getId());
        if (v.isPresent()) {
            Storage worker = (Storage) v.get();
            if (storageDto.getName() != null) {
                worker.setName(storageDto.getName());
            }

            if (storageDto.getAddress() != null) {
                worker.setAddress(storageDto.getAddress());
            }

            if (storageDto.getInfo() != null) {
                worker.setInfo(storageDto.getInfo());
            }

            w = worker;
        }

        return this.saveStorage(new StorageDto(w));
    }
}
