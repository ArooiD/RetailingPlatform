package ru.mirea.showcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.sdk.entity.showcase.Promo;

import java.util.UUID;

@Repository
public interface PromoRepository extends JpaRepository<Promo, UUID> {
}
