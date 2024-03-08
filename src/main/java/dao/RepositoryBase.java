package dao;

import dao.api.Repository;
import dao.impl.AccountDaoImpl;
import data.AccountDto;
import entity.Account;
import lombok.RequiredArgsConstructor;
import mapper.AccountMapperImpl;
import mapper.DtoEntityMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.hibernate.HibernateUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class RepositoryBase<K extends Serializable, E, D> implements Repository<K, E, D> {
    private final SessionFactory sessionFactory;
    private final Class<E> clazz;
    private final Class<D> dtoClass;
    private final DtoEntityMapper<E, D> mapper;

    public Optional<D> findById(K id) {
        var session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            E entity = session.find(clazz, id);
            session.getTransaction().commit();
            return Optional.ofNullable(entity != null ? mapper.toDto(entity) : null);
        } catch (RuntimeException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
       DtoEntityMapper<Account, AccountDto> mapper = new AccountMapperImpl();
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            RepositoryBase<Long, Account, AccountDto> repository = new AccountDaoImpl(sessionFactory,mapper);
            session.beginTransaction();
            Long id = 1L;
            Optional<AccountDto> result = repository.findById(id);

            if (result.isPresent()) {
                AccountDto entityDto = result.get();
                System.out.println("Entity found: " + entityDto);
            } else {
                System.out.println("Entity with ID " + id + " not found.");
            }

            session.getTransaction().commit();
        }
    }
    @Override
    public List<E> findAll() {
        var session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        var criteria = session.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        session.getTransaction().commit();
        return session.createQuery(criteria)
                .getResultList();
    }

    @Override
    public E save(E e) {
        var session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        return e;
    }

    @Override
    public void update(E e) {
        var session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(e);
        session.getTransaction().commit();
    }

    @Override
    public void delete(K id) {
        var session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(id);
        session.flush();
        session.getTransaction().commit();
    }
}
