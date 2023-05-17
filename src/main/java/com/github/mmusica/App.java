package com.github.mmusica;


import com.github.mmusica.model.Producer;
import com.github.mmusica.model.Product;
import com.github.mmusica.repository.ProducerRepository;


public class App {
    public static void main (String[] args){

        var producerRepository = new ProducerRepository("product_pu");



        var producer = new Producer();
        producer.setName("Musica Marko");
        producer.addProduct(new Product("Millk",3));
        producer.addProduct(new Product("new",3));
        producerRepository.add(producer);
        producerRepository.delete(producer);

    }
}
