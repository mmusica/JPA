package com.github.mmusica.model;


import com.github.mmusica.repository.ProductRepository;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ProductRepositoryTest {

    private static ProductRepository productRepository;
    @BeforeClass
    public static void beforeClass(){
        productRepository = new ProductRepository("product_pu_test");
    }
    @AfterClass
    public static void afterClass(){
        productRepository.close();
    }

    @Test
    public void testAdd() {
        var product = new Product();
        product.setName("Meat");
        product.setQuantity(4);
        product.addProducer(new Producer("Dino1"));
        productRepository.add(product);
        Assert.assertNotNull(product.getId());
        Assert.assertTrue(product.getId() == 1);
    }
    @Test
    public void testFind() {
        var product = new Product();
        product.setName("Milk");
        product.setQuantity(2);
        product.addProducer(new Producer("Dino2"));
        productRepository.add(product);
        var found =  productRepository.find(product.getId());
        Assert.assertNotNull(found);
    }
    @Test
    public void testUpdate() {
        var product = new Product();
        product.setName("Milk");
        product.setQuantity(2);
        product.addProducer(new Producer("Dino3"));
        productRepository.add(product);
        var newProduct = new Product();
        newProduct.setQuantity(2);
        newProduct.setName("newMilk");
        product.addProducer(new Producer("Loto"));
        var found =  productRepository.update(newProduct,product.getId());
        Assert.assertEquals("newMilk", found.getName());
        Assert.assertEquals(2, found.getQuantity());
    }
    @Test
    public void testDelete() {
        var product = new Product();
        product.setName("Milk");
        product.setQuantity(2);
        product.addProducer(new Producer("Dino4"));
        productRepository.add(product);
        productRepository.delete(product);
        var found = productRepository.find(product.getId());
        Assert.assertNull(found);
    }
}