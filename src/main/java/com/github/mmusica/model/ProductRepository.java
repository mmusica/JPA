package com.github.mmusica.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductRepository {

    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public ProductRepository(String persistenceUnitName){
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.entityManager = this.emf.createEntityManager();
    }
    public Product add(Product product){

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }
    public Product find(Long id){
        return entityManager.find(Product.class,id);
    }
    public Product update(Product product, Long id){
        var productToUpdate = this.find(id);
        entityManager.getTransaction().begin();
        productToUpdate.setName(product.getName());
        productToUpdate.setQuantity(product.getQuantity());
        entityManager.getTransaction().commit();
        return productToUpdate;
    }
    public void delete(Product product){
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
}
