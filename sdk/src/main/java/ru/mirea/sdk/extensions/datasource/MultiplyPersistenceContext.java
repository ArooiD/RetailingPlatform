package ru.mirea.sdk.extensions.datasource;

import java.lang.annotation.*;

@Repeatable(MultiplyPersistenceContextContainer.class)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiplyPersistenceContext {
    String persistenceUnitName() default "";
}
