package ru.mirea.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.storage.entity.Storage;

import java.util.UUID;

@Repository
public interface StorageRepository extends JpaRepository<Storage, UUID> {
}