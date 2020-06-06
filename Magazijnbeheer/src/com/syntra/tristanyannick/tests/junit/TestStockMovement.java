package com.syntra.tristanyannick.tests.junit;

import com.syntra.tristanyannick.model.products.Book;
import com.syntra.tristanyannick.model.products.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStockMovement {

    private Product testProduct;

    @BeforeEach
    public void setUp() {
        testProduct = new Book(250, 1000);
        testProduct.getStatus().sell(testProduct, 25);
    }

    @AfterEach
    public void tearDown() {
        testProduct = null;
    }

    @Test
    public void testGetDirection() {
        assertTrue(testProduct.getStocks().getFirst().getStockMovement().getDirection().equalsIgnoreCase("OUT"));
    }

    @Test
    public void testGetAction() {
        assertTrue(testProduct.getStocks().getFirst().getStockMovement().getAction().equalsIgnoreCase("SELL"));
    }

    @Test
    public void testToString() {
        assertTrue(testProduct.getStocks().getFirst().getStockMovement().toString().equalsIgnoreCase("OUT.SELL"));
    }
}
