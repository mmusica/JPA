package com.github.mmusica;


import com.github.mmusica.model.Client;
import com.github.mmusica.model.Producer;
import com.github.mmusica.model.Product;
import com.github.mmusica.repository.ClientRepository;
import com.github.mmusica.repository.ProducerRepository;
import jakarta.persistence.EntityManager;


public class App {
    public static void main (String[] args){

        var producerRepository = new ProducerRepository("product_pu");
        var clientRepository = new ClientRepository("product_pu");


        var producer = new Producer();
        producer.setName("Musica Marko");
        var product1 = new Product("Millk",3);
        producer.addProduct(product1);
        var product2 = new Product("new",3);
        producer.addProduct(product2);
        producerRepository.add(producer);
        // producerRepository.delete(producer);
        producerRepository.close();

        var client = new Client();
        client.setAddress("Ul. Julija Merlica 9");
        client.setName("Marko");
        var productClient1 = new Product("productC1",1);
        productClient1.setProducer(producer);
        client.addProduct(product1);
        client.addProduct(product1);
        clientRepository.add(client);
        clientRepository.close();


       // clientRepository.delete(client);



    }
}
