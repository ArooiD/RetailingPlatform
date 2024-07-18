package ru.mirea.sdk.extensions.datasource;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.metamodel.Metamodel;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MultiplyEntityManagerImpl implements MultiplyEntityManager {

    private final Supplier<EntityManager> entityManagerSupplier;

    public MultiplyEntityManagerImpl(Supplier<EntityManager> entityManagerSupplier) {
        this.entityManagerSupplier = entityManagerSupplier;
    }

    private EntityManager getEntityManager() {
        return entityManagerSupplier.get();
    }

    @Override
    public void persist(Object entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public <T> T merge(T entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    public void remove(Object entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey) {
        return getEntityManager().find(entityClass, primaryKey);
    }

    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
        return getEntityManager().find(entityClass, primaryKey, properties);
    }

    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
        return getEntityManager().find(entityClass, primaryKey, lockMode);
    }

    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
        return getEntityManager().find(entityClass, primaryKey, lockMode, properties);
    }

    @Override
    public <T> T getReference(Class<T> entityClass, Object primaryKey) {
        return getEntityManager().getReference(entityClass, primaryKey);
    }

    @Override
    public void flush() {
        getEntityManager().flush();
    }

    @Override
    public FlushModeType getFlushMode() {
        return getEntityManager().getFlushMode();
    }

    @Override
    public void setFlushMode(FlushModeType flushMode) {
        getEntityManager().setFlushMode(flushMode);
    }

    @Override
    public void lock(Object entity, LockModeType lockMode) {
        getEntityManager().lock(entity, lockMode);
    }

    @Override
    public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
        getEntityManager().lock(entity, lockMode, properties);
    }

    @Override
    public void refresh(Object entity) {
        getEntityManager().refresh(entity);
    }

    @Override
    public void refresh(Object entity, Map<String, Object> properties) {
        getEntityManager().refresh(entity, properties);
    }

    @Override
    public void refresh(Object entity, LockModeType lockMode) {
        getEntityManager().refresh(entity, lockMode);
    }

    @Override
    public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
        getEntityManager().refresh(entity, lockMode, properties);
    }

    @Override
    public void clear() {
        getEntityManager().clear();
    }

    @Override
    public void detach(Object entity) {
        getEntityManager().detach(entity);
    }

    @Override
    public boolean contains(Object entity) {
        return getEntityManager().contains(entity);
    }

    @Override
    public LockModeType getLockMode(Object entity) {
        return getEntityManager().getLockMode(entity);
    }

    @Override
    public void setProperty(String propertyName, Object value) {
        getEntityManager().setProperty(propertyName, value);
    }

    @Override
    public Map<String, Object> getProperties() {
        return getEntityManager().getProperties();
    }

    @Override
    public Query createQuery(String qlString) {
        return getEntityManager().createQuery(qlString);
    }

    @Override
    public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
        return getEntityManager().createQuery(criteriaQuery);
    }

    @Override
    public Query createQuery(CriteriaUpdate updateQuery) {
        return getEntityManager().createQuery(updateQuery);
    }

    @Override
    public Query createQuery(CriteriaDelete deleteQuery) {
        return getEntityManager().createQuery(deleteQuery);
    }

    @Override
    public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
        return getEntityManager().createQuery(qlString, resultClass);
    }

    @Override
    public Query createNamedQuery(String name) {
        return getEntityManager().createNamedQuery(name);
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
        return getEntityManager().createNamedQuery(name, resultClass);
    }

    @Override
    public Query createNativeQuery(String sqlString) {
        return getEntityManager().createNativeQuery(sqlString);
    }

    @Override
    public Query createNativeQuery(String sqlString, Class resultClass) {
        return getEntityManager().createNativeQuery(sqlString, resultClass);
    }

    @Override
    public Query createNativeQuery(String sqlString, String resultSetMapping) {
        return getEntityManager().createNativeQuery(sqlString, resultSetMapping);
    }

    @Override
    public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
        return getEntityManager().createNamedStoredProcedureQuery(name);
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
        return getEntityManager().createStoredProcedureQuery(procedureName);
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses) {
        return getEntityManager().createStoredProcedureQuery(procedureName, resultClasses);
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
        return getEntityManager().createStoredProcedureQuery(procedureName, resultSetMappings);
    }

    @Override
    public void joinTransaction() {
        getEntityManager().joinTransaction();
    }

    @Override
    public boolean isJoinedToTransaction() {
        return getEntityManager().isJoinedToTransaction();
    }

    @Override
    public <T> T unwrap(Class<T> cls) {
        return getEntityManager().unwrap(cls);
    }

    @Override
    public Object getDelegate() {
        return getEntityManager().getDelegate();
    }

    @Override
    public void close() {
        getEntityManager().close();
    }

    @Override
    public boolean isOpen() {
        return getEntityManager().isOpen();
    }

    @Override
    public EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return getEntityManager().getEntityManagerFactory();
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return getEntityManager().getCriteriaBuilder();
    }

    @Override
    public Metamodel getMetamodel() {
        return getEntityManager().getMetamodel();
    }

    @Override
    public <T> EntityGraph<T> createEntityGraph(Class<T> aClass) {
        return getEntityManager().createEntityGraph(aClass);
    }

    @Override
    public EntityGraph<?> createEntityGraph(String name) {
        return getEntityManager().createEntityGraph(name);
    }

    @Override
    public EntityGraph<?> getEntityGraph(String name) {
        return getEntityManager().getEntityGraph(name);
    }

    @Override
    public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
        return getEntityManager().getEntityGraphs(entityClass);
    }

}