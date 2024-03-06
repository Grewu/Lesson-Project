package dao.api;

import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class DaoBase<K extends Serializable, E> implements Dao<K, E> {
    private final SessionFactory sessionFactory;
    private final Class<E> clazz;

    @Override
    public Optional<E> findById(K id) {
        @Cleanup var session = sessionFactory.openSession();
        E account = session.find(clazz, id);
        return Optional.ofNullable(account);
    }


    @Override
    public List<E> findAll() {
        @Cleanup var session = sessionFactory.openSession();
        var criteria = session.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        return session.createQuery(criteria)
                .getResultList();
    }

    @Override
    public E save(E e) {
        @Cleanup var session = sessionFactory.openSession();
        session.save(e);
        return e;
    }

    @Override
    public void update(E e) {
        @Cleanup var session = sessionFactory.openSession();
        session.merge(e);
    }

    @Override
    public void delete(K id) {
        @Cleanup var session = sessionFactory.openSession();
        session.delete(id);
        session.flush();
    }
}
