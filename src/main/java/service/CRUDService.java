package service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CRUDService<K, V extends Serializable, D> {
    Optional<D> findById(V id);

    List<K> findAll();

    K create(D dto);

    void update(D dto);

    void delete(V id);
}
