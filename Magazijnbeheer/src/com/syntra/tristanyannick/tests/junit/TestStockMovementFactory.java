package com.syntra.tristanyannick.tests.junit;

import com.syntra.tristanyannick.factories.StockMovementFactory;
import com.syntra.tristanyannick.model.stock.StockMovement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStockMovementFactory {

    private StockMovementFactory stockMovementFactory;
    private StockMovement testStockMovement;

    @BeforeEach
    public void setUp() {
        stockMovementFactory = StockMovementFactory.getInstance();
    }

    @AfterEach
    public void tearDown() {
        stockMovementFactory = null;
        testStockMovement = null;
    }

    @Test
    public void testSingleton() {
        assertEquals(stockMovementFactory, StockMovementFactory.getInstance());
    }

    @Test
    public void testCreateStockInBuy() {
        testStockMovement = stockMovementFactory.createStockMovement(0);
        assertEquals(testStockMovement, StockMovement.IN_BUY);
    }

    @Test
    public void testCreateStockInProduction() {
        testStockMovement = stockMovementFactory.createStockMovement(1);
        assertEquals(testStockMovement, StockMovement.IN_PRODUCTION);
    }

    @Test
    public void testCreateStockOutSell() {
        testStockMovement = stockMovementFactory.createStockMovement(2);
        assertEquals(testStockMovement, StockMovement.OUT_SELL);
    }

    @Test
    public void testCreateStockOutRelocate() {
        testStockMovement = stockMovementFactory.createStockMovement(3);
        assertEquals(testStockMovement, StockMovement.OUT_RELOCATE);
    }

    @Test
    public void testCreateStockOutRemove() {
        testStockMovement = stockMovementFactory.createStockMovement(4);
        assertEquals(testStockMovement, StockMovement.OUT_REMOVE);
    }

    @Test
    public void testCreateRandomStock() {
        testStockMovement = stockMovementFactory.createRandomStockMovement();
        assertTrue(testStockMovement instanceof StockMovement);
    }
}
