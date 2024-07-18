package ru.mirea.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.sdk.dto.storage.StorageDto;
import ru.mirea.storage.service.StorageService;

import java.util.List;

@RestController
@RequestMapping({"/storages"})
public class StorageController {
    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping({"/show"})
    public List<StorageDto> showWorkers(@RequestBody(required = false) StorageDto storageDto) {
        return this.storageService.getStorages(storageDto);
    }

    @PostMapping({"/add"})
    public StorageDto addWorker(@RequestBody StorageDto storageDto) {
        return this.storageService.saveStorage(storageDto);
    }

    @PutMapping({"/edit"})
    public StorageDto editWorker(@RequestBody StorageDto storageDto) {
        return this.storageService.editStorage(storageDto);
    }

    @DeleteMapping({"/remove"})
    public StorageDto removeWorker(@RequestBody StorageDto storageDto) {
        return this.storageService.deleteStorage(storageDto);
    }
}