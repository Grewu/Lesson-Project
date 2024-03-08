package dao.api;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<K extends Serializable, E,D> {

    Optional<D> findById(K id);

    List<E> findAll();


    E save(E product);

    void update(E account);


    void delete(K id);
}
