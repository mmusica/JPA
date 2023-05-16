package com.github.mmusica.repository;

import com.github.mmusica.interfaces.GeneralRepository;
import com.github.mmusica.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductRepository implements GeneralRepository<Product> {

    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public ProductRepository(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
        this.entityManager = this.emf.createEntityManager();
    }

    @Override
    public Product add(Product product){

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }
    @Override
    public Product find(Long id){
        return entityManager.find(Product.class,id);
    }
    @Override
    public Product update(Product product, Long id){
        var productToUpdate = this.find(id);
        entityManager.getTransaction().begin();
        productToUpdate.setName(product.getName());
        productToUpdate.setQuantity(product.getQuantity());
        entityManager.getTransaction().commit();
        return productToUpdate;
    }
    @Override
    public void delete(Product product){
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
    @Override
    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
}
