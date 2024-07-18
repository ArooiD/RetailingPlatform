package ru.mirea.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.sdk.dto.storage.ProviderDto;
import ru.mirea.storage.service.ProviderService;

import java.util.List;

@RestController
@RequestMapping({"/provider"})
public class ProviderController {
    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping({"/show"})
    public List<ProviderDto> showWorkers(@RequestBody(required = false) ProviderDto providerDto) {
        return this.providerService.getProviders(providerDto);
    }

    @PostMapping({"/add"})
    public ProviderDto addWorker(@RequestBody ProviderDto providerDto) {
        return this.providerService.saveProvider(providerDto);
    }

    @PutMapping({"/edit"})
    public ProviderDto editWorker(@RequestBody ProviderDto providerDto) {
        return this.providerService.editProvider(providerDto);
    }

    @DeleteMapping({"/remove"})
    public ProviderDto removeWorker(@RequestBody ProviderDto providerDto) {
        return this.providerService.deleteProvider(providerDto);
    }
}