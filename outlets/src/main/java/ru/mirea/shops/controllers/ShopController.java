package ru.mirea.shops.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.sdk.dto.outlets.ShopDto;
import ru.mirea.shops.services.ShopService;


import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(final ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/show")
    public List<ShopDto> showShop(@RequestBody(required = false) ShopDto shopDto) {
        return shopService.getShop(shopDto);
    }

    @PostMapping("/add")
    public ShopDto addShop(@RequestBody ShopDto shopDto) {
        return shopService.saveShop(shopDto);
    }

    @PutMapping("/edit")
    public ShopDto editShop(@RequestBody ShopDto shopDto) {
        return shopService.editShop(shopDto);
    }

    @DeleteMapping ("/remove")
    public ShopDto removeShop(@RequestBody ShopDto shopDto) {
        return shopService.deleteShop(shopDto);
    }
}
