package com.github.mmusica.repository;

import com.github.mmusica.interfaces.GeneralRepository;
import com.github.mmusica.model.Producer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProducerRepository implements GeneralRepository<Producer> {

    private final EntityManagerFactory emf;
    private final EntityManager entityManager;


    public ProducerRepository(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
        this.entityManager = this.emf.createEntityManager();
    }

    @Override
    public Producer add(Producer entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Producer find(Long id) {return entityManager.find(Producer.class,id);}

    @Override
    public Producer update(Producer entity, Long id) {
        var producerToUpdate = this.find(id);
        entityManager.getTransaction().begin();
        producerToUpdate.setId(entity.getId());
        producerToUpdate.setName(entity.getName());
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Producer entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
