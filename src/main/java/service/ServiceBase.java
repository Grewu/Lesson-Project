package service;

import dao.RepositoryBase;
import mapper.DtoEntityMapper;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class ServiceBase<E, K extends Serializable, D> {
    protected final DtoEntityMapper<E, D> mapper;
    protected final RepositoryBase<K, E, D> repositoryBase;

    public ServiceBase(DtoEntityMapper<E, D> mapper, RepositoryBase<K, E, D> repositoryBase) {
        this.mapper = mapper;
        this.repositoryBase = repositoryBase;
    }

    public Optional<D> findById(K id) {
        return repositoryBase.findById(id);
    }

    public List<E> findAll() {
        return repositoryBase.findAll();
    }

    public E create(D dto) {
        E entity = mapper.toEntity(dto);
        repositoryBase.save(entity);
        return entity;
    }

    public void update(D dto) {
        E entity = mapper.toEntity(dto);
        repositoryBase.update(entity);
    }

    public void delete(K id) {
        repositoryBase.delete(id);
    }
}