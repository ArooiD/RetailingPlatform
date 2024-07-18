package ru.mirea.shops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.sdk.entity.outlets.Shop;

import java.util.UUID;


@Repository
public interface ShopRepository extends JpaRepository<Shop, UUID> {
}
