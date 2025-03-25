package com.example.apifull_security.DAO;

import com.example.funkoapi.entity.Funko;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FunkoDAOImpl implements FunkoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Funko> findAll() {
        return entityManager.createQuery("FROM Funko", Funko.class).getResultList();
    }

    @Override
    public Funko findById(Long id) {
        return entityManager.find(Funko.class, id);
    }

    @Override
    public Funko save(Funko funko) {
        if (funko.getId() == null) {
            entityManager.persist(funko);
            return funko;
        } else {
            return entityManager.merge(funko);
        }
    }

    @Override
    public void deleteById(Long id) {
        Funko funko = findById(id);
        if (funko != null) {
            entityManager.remove(funko);
        }
    }
}