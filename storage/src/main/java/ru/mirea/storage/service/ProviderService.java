package ru.mirea.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.dto.storage.ProviderDto;
import ru.mirea.sdk.entity.storage.Provider;
import ru.mirea.storage.repository.ProviderRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<ProviderDto> getProviders(ProviderDto providerDto) {
        if (providerDto == null) {
            return this.providerRepository.findAll().stream().map(provider -> new ProviderDto()).toList();
        } else if (providerDto.getId() != null) {
            Optional<Provider> provider = this.providerRepository.findById(providerDto.getId());
            return provider.map(worker -> List.of(new ProviderDto())).orElseGet(() -> List.of(new ProviderDto()));
        } else {
            throw new RuntimeException("No worker found");
        }
    }

    public ProviderDto saveProvider(ProviderDto dto) {
        return new ProviderDto();
    }

    public ProviderDto deleteProvider(ProviderDto dto) {
        AtomicReference<Provider> w = new AtomicReference();
        this.providerRepository.findById(dto.getId()).ifPresent((worker) -> {
            w.set(worker);
            this.providerRepository.deleteById(dto.getId());
        });
        return new ProviderDto();
    }

    public ProviderDto editProvider(ProviderDto providerDto) {
        Provider w = new Provider(providerDto);
        Optional<Provider> v = this.providerRepository.findById(providerDto.getId());
        if (v.isPresent()) {
            Provider worker = (Provider) v.get();
            if (providerDto.getName() != null) {
                worker.setName(providerDto.getName());
            }

            if (providerDto.getInfo() != null) {
                worker.setInfo(providerDto.getInfo());
            }

            w = worker;
        }

        return this.saveProvider(new ProviderDto());
    }
}
