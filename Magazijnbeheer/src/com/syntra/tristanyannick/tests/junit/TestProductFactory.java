package com.syntra.tristanyannick.tests.junit;

import com.syntra.tristanyannick.factories.ProductFactory;
import com.syntra.tristanyannick.model.products.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestProductFactory {

    private Product testProduct;
    private ProductFactory productFactory;

    @BeforeEach
    public void setUp() {
        productFactory = ProductFactory.getInstance();
        testProduct = new Book(250, 1000);
    }

    @AfterEach
    public void tearDown() {
        productFactory = null;
        testProduct = null;
    }

    @Test
    public void testSingleton() {
        assertEquals(productFactory, ProductFactory.getInstance());
    }

    @Test
    public void testCreateProductBook() {
        String choice = "book";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Book(250, 1000));
    }

    @Test
    public void testCreateProductChair() {
        String choice = "chair";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Chair(250, 1000));
    }

    @Test
    public void testCreateProductDesk() {
        String choice = "desk";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Desk(250, 1000));
    }

    @Test
    public void testCreateProductGlass() {
        String choice = "glass";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Glass(250, 1000));
    }

    @Test
    public void testCreateProductLaptop() {
        String choice = "laptop";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Laptop(250, 1000));
    }

    @Test
    public void testCreateProductMonitor() {
        String choice = "monitor";
        testProduct = productFactory.createProduct(choice);
        System.out.println(testProduct);
        assertEquals(testProduct, new Monitor(250, 1000));
    }

    @Test
    public void testCreateProductMonopoly() {
        String choice = "monopoly";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Monopoly(250, 1000));
    }

    @Test
    public void testCreateProductMouse() {
        String choice = "mouse";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Mouse(250, 1000));
    }

    @Test
    public void testCreateProductRazor() {
        String choice = "razor";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Razor(250, 1000));
    }

    @Test
    public void testCreateProductWallet() {
        String choice = "wallet";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Wallet(250, 1000));
    }

    @Test
    public void testCreateProductXbox() {
        String choice = "xbox";
        testProduct = productFactory.createProduct(choice);
        assertEquals(testProduct, new Xbox(250, 1000));
    }

    @Test
    public void testCreateProductNull() {
        String choice = "nothing valid";
        testProduct = productFactory.createProduct(choice);
        assertNull(testProduct);
    }

    @Test
    public void testCreateRandomProduct() {
        testProduct = productFactory.createRandomProduct();
        assertNotNull(testProduct);
    }
}
