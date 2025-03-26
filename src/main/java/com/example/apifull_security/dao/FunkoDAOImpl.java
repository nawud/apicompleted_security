package com.example.apifull_security.dao;

import com.example.apifull_security.entity.Funko;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FunkoDAOImpl implements FunkoDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public FunkoDAOImpl( EntityManager entityManager ) { this.entityManager = entityManager; }

    @Override
    @Transactional
    public void save(Funko theFunko) { this.entityManager.persist(theFunko); }

    @Override
    public Funko findById(int id) {
        return entityManager.find(Funko.class, id);
    }

    @Override
    public List<Funko> findAll() {

        TypedQuery<Funko> theQuery = entityManager.createQuery("FROM Funko", Funko.class);

        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Funko theFunko) { entityManager.merge(theFunko); }

    @Override
    @Transactional
    public void delete(int id) {

        Funko funko = this.entityManager.find(Funko.class, id);

        entityManager.remove(funko);

    }

}