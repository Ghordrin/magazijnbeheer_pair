package com.syntra.tristanyannick.tests.junit;

import com.syntra.tristanyannick.model.products.Book;
import com.syntra.tristanyannick.model.products.Chair;
import com.syntra.tristanyannick.model.products.Product;
import com.syntra.tristanyannick.model.statuses.Critical;
import com.syntra.tristanyannick.model.stock.Stock;
import com.syntra.tristanyannick.model.stock.StockMovement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProduct {
    private Product testProduct1;
    private Product testProduct2;


    @BeforeEach
    public void setUp() {
        testProduct1 = new Book(250, 1000);
        testProduct1.sell(25);
        testProduct2 = new Chair(10, 50);
    }

    @AfterEach
    public void tearDown() {
        testProduct1 = null;
        testProduct2 = null;
    }

    @Test
    public void testGetCurrentStockNoStocks() {
        Product product = new Book(250, 1000);
        int initialStock = product.getInitialStock();
        assertEquals(initialStock, product.getCurrentStock());
    }

    @Test
    public void testGetCurrentStockWithStocks() {
        testProduct1.buy(20);
        testProduct1.produce(15);
        testProduct1.remove(10);
        testProduct1.relocate(5);
        int currentStock = testProduct1.getInitialStock() - 25 + 20 + 15 - 10 - 5;
        assertEquals(currentStock, testProduct1.getCurrentStock());
    }

    @Test
    public void testGetFreeSpace() {
        int freeSpace = testProduct1.AMOUNT_HIGH - testProduct1.getCurrentStock();
        assertEquals(freeSpace, testProduct1.getFreeSpace());
    }

    @Test
    public void testAddStock() {
        testProduct1.addStock(new Stock(StockMovement.IN_BUY, true, 10));
        assertEquals(2, testProduct1.getStocks().size());
    }

    @Test
    public void testSetStatus() {
        testProduct1.setStatus(new Critical());
        assertEquals(testProduct1.getStatus(), new Critical());
    }

    @Test
    public void testGetName() {
        assertEquals("Book", testProduct1.getName());
    }

    @Test
    public void testGetStocks() {
        LinkedList<Stock> stockMovements = new LinkedList<>(testProduct1.getStocks());
        assertEquals(testProduct1.getStocks(), stockMovements);
    }

    @Test
    public void testGetStatus() {
        testProduct1.setStatus(new Critical());
        assertEquals(testProduct1.getStatus(), new Critical());
    }

    @Test
    public void testGetInitialStock() {
        int initialStock = testProduct1.getCurrentStock() + 25;
        assertEquals(testProduct1.getInitialStock(), initialStock);
    }

    @Test
    public void testToString() {
        StringBuilder allStockValidations = new StringBuilder();
        for (Stock stock : testProduct1.getStocks()) {
            if (allStockValidations.length() > 0)
                allStockValidations.append("\n");
            allStockValidations.append("\t\t");
            allStockValidations.append(stock.toString());
        }
        String toString = "Book:\n\tCritical: " + testProduct1.AMOUNT_CRITICAL + "; LOW: " + testProduct1.AMOUNT_LOW +
                "; HIGH: " + testProduct1.AMOUNT_HIGH + ";\n" +
                "\tCurrent stock: " + testProduct1.getCurrentStock() + "\n\tStatus: " + testProduct1.getStatus().toString() +
                "\n" + allStockValidations;
        assertEquals(testProduct1.toString(), toString);
    }

    @Test
    public void testCompareToMinusOne() {
        assertEquals(-1, testProduct1.compareTo(testProduct2));
    }

    @Test
    public void testCompareToZero() {
        assertEquals(0, testProduct1.compareTo(testProduct1));
    }

    @Test
    public void testCompareToOne() {
        assertEquals(1, testProduct2.compareTo(testProduct1));
    }
}
