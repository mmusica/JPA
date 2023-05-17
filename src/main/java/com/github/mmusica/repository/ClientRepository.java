package com.github.mmusica.repository;

import com.github.mmusica.interfaces.GeneralRepository;
import com.github.mmusica.model.Client;
import com.github.mmusica.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientRepository implements GeneralRepository<Client> {

    private final EntityManagerFactory emf;
    private final EntityManager entityManager;
    public ClientRepository(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager = this.emf.createEntityManager();
    }

    @Override
    public Client add(Client entity) {

        entityManager.getTransaction().begin();

        for(Product product : entity.getProductSet()){
            entity.getProductSet().remove(product);
            entity.getProductSet().add(entityManager.merge(product));
        }
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Client find(Long id) {return entityManager.find(Client.class,id);}

    @Override
    public Client update(Client entity, Long id) {
        var clientToUpdate = this.find(id);
        entityManager.getTransaction().begin();
        clientToUpdate.setId(entity.getId());
        clientToUpdate.setName(entity.getName());
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Client entity) {
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
