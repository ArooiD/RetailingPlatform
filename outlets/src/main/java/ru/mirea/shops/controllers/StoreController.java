package ru.mirea.shops.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.sdk.dto.outlets.StoreDto;
import ru.mirea.shops.services.StoreService;


import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @Autowired
    public StoreController(final StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/show")
    public List<StoreDto> showStore(@RequestBody(required = false) StoreDto storeDto) {
        return storeService.getShop(storeDto);
    }

    @PostMapping("/add")
    public StoreDto addStore(@RequestBody StoreDto storeDto) {
        return storeService.saveStore(storeDto);
    }

    @PutMapping("/edit")
    public StoreDto editStore(@RequestBody StoreDto storeDto) {
        return storeService.editStore(storeDto);
    }

    @DeleteMapping ("/remove")
    public StoreDto removeStore(@RequestBody StoreDto storeDto) {
        return storeService.deleteStore(storeDto);
    }
}