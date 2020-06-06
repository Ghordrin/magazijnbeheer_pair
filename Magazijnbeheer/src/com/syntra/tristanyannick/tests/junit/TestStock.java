package com.syntra.tristanyannick.tests.junit;

import com.syntra.tristanyannick.model.stock.Stock;
import com.syntra.tristanyannick.model.stock.StockMovement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStock {
    private Stock stock;

    @BeforeEach
    public void setUp() {
        StockMovement stockMovement = StockMovement.IN_BUY;
        stock = new Stock(stockMovement, true, 50);
    }

    @AfterEach
    public void tearDown() {
        stock = null;
    }

    @Test
    public void testGetAmount() {
        assertEquals(50, stock.getAmount());
    }

    @Test
    public void testGetStockMovement() {
        assertSame(stock.getStockMovement(), (StockMovement.IN_BUY));
    }

    @Test
    public void testIsHasHappened() {
        assertTrue(stock.isHasHappened());
    }

    @Test
    public void testToString() {
        assertTrue(stock.toString().equalsIgnoreCase(stock.getStockMovement().toString() +
                ": " + stock.getAmount() + "; has happened: " + stock.isHasHappened()));
    }
}
