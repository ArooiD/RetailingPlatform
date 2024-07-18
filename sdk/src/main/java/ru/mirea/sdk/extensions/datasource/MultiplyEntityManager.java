package ru.mirea.sdk.extensions.datasource;

import jakarta.persistence.EntityManager;

public interface MultiplyEntityManager extends EntityManager, AutoCloseable {

}
