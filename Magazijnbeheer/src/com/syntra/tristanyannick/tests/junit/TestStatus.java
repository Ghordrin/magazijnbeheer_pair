package com.syntra.tristanyannick.tests.junit;

import com.syntra.tristanyannick.model.products.Book;
import com.syntra.tristanyannick.model.products.Product;
import com.syntra.tristanyannick.model.statuses.Critical;
import com.syntra.tristanyannick.model.statuses.High;
import com.syntra.tristanyannick.model.statuses.Low;
import com.syntra.tristanyannick.model.statuses.Normal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStatus {
    private Product testProduct;

    @BeforeEach
    public void setUp() {
        testProduct = new Book(250, 1000);
    }

    @AfterEach
    public void tearDown() {
        testProduct = null;
    }

    //Buy() stock
    @Test
    public void testStockBuyCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(10);
        assertEquals(110, testProduct.getCurrentStock());
    }

    @Test
    public void testStockBuyLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.buy(10);
        assertEquals(210, testProduct.getCurrentStock());
    }

    @Test
    public void testStockBuyNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.buy(10);
        assertEquals(510, testProduct.getCurrentStock());
    }

    @Test
    public void testStockBuyStockHigh() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.buy(10);
        assertEquals(1000, testProduct.getCurrentStock());
    }

    //Buy() status CRITICAL
    @Test
    public void testStatusBuyCriticalStillCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(10);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    @Test
    public void testStatusBuyCriticalToLow() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(100);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusBuyCriticalToNormal() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(400);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusBuyCriticalToHigh() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(5000);
        assertEquals(testProduct.getStatus(), new High());
    }

    //Buy() status LOW
    @Test
    public void testStatusBuyLowStillLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.buy(10);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusBuyLowToNormal() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.buy(300);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusBuyLowToHigh() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(5000);
        assertEquals(testProduct.getStatus(), new High());
    }

    //Buy() status NORMAL
    @Test
    public void testStatusBuyNormalStillNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.buy(10);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusBuyNormalToHigh() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.buy(5000);
        assertEquals(testProduct.getStatus(), new High());
    }

    //Buy() status HIGH
    @Test
    public void testStatusBuyHighStillHigh() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.buy(10);
        assertEquals(testProduct.getStatus(), new High());
    }

    //-----------------------------------
    //Produce() stock
    @Test
    public void testStockProduceCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(10);
        assertEquals(110, testProduct.getCurrentStock());
    }

    @Test
    public void testStockProduceLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.produce(10);
        assertEquals(210, testProduct.getCurrentStock());
    }

    @Test
    public void testStockProduceNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.produce(10);
        assertEquals(510, testProduct.getCurrentStock());
    }

    @Test
    public void testStockProduceStockHigh() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.produce(10);
        assertEquals(1000, testProduct.getCurrentStock());
    }

    //Produce() status CRITICAL
    @Test
    public void testStatusProduceCriticalStillCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(10);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    @Test
    public void testStatusProduceCriticalToLow() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(100);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusProduceCriticalToNormal() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(400);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusProduceCriticalToHigh() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(5000);
        assertEquals(testProduct.getStatus(), new High());
    }

    //Produce() status LOW
    @Test
    public void testStatusProduceLowStillLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.produce(10);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusProduceLowToNormal() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.produce(300);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusProduceLowToHigh() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(5000);
        assertEquals(testProduct.getStatus(), new High());
    }

    //Produce() status NORMAL
    @Test
    public void testStatusProduceNormalStillNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.produce(10);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusProduceNormalToHigh() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.produce(5000);
        assertEquals(testProduct.getStatus(), new High());
    }

    //Produce() status HIGH
    @Test
    public void testStatusProduceHighStillHigh() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.produce(10);
        assertEquals(testProduct.getStatus(), new High());
    }

    //-----------------------------------
    //Remove() stock
    @Test
    public void testStockRemoveCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.remove(10);
        assertEquals(100, testProduct.getCurrentStock());
    }

    @Test
    public void testStockRemoveLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.remove(10);
        assertEquals(190, testProduct.getCurrentStock());
    }

    @Test
    public void testStockRemoveNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.remove(10);
        assertEquals(490, testProduct.getCurrentStock());
    }

    @Test
    public void testStockRemoveStockHigh() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.remove(10);
        assertEquals(990, testProduct.getCurrentStock());
    }

    //Remove() status CRITICAL
    @Test
    public void testStatusRemoveCriticalStillCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.remove(10);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //Remove() status Low
    @Test
    public void testStatusRemoveLowStillLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.remove(10);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusRemoveLowToCritical() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.remove(200);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //Remove() status NORMAL
    @Test
    public void testStatusRemoveNormalStillNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.remove(10);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusRemoveNormalToLow() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.remove(300);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusRemoveNormalToCritical() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.remove(400);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //Remove() status HIGH
    @Test
    public void testStatusRemoveHighToNormal() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.remove(400);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusRemoveHighToLow() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.remove(800);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusRemoveHighToCritical() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.remove(900);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //-----------------------------------
    //Sell() stock
    @Test
    public void testStockSellCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.sell(10);
        assertEquals(100, testProduct.getCurrentStock());
    }

    @Test
    public void testStockSellLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.sell(10);
        assertEquals(190, testProduct.getCurrentStock());
    }

    @Test
    public void testStockSellNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.sell(10);
        assertEquals(490, testProduct.getCurrentStock());
    }

    @Test
    public void testStockSellStockHigh() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.sell(10);
        assertEquals(990, testProduct.getCurrentStock());
    }

    //Sell() status CRITICAL
    @Test
    public void testStatusSellCriticalStillCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.sell(10);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //Sell() status Low
    @Test
    public void testStatusSellLowStillLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.sell(10);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusSellLowToCritical() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.sell(200);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //Sell() status NORMAL
    @Test
    public void testStatusSellNormalStillNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.sell(10);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusSellNormalToLow() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.sell(300);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusSellNormalToCritical() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.sell(400);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //Sell() status HIGH
    @Test
    public void testStatusSellHighToNormal() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.sell(400);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusSellHighToLow() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.sell(800);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusSellHighToCritical() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.sell(900);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //-----------------------------------
    //Relocate() stock
    @Test
    public void testStockRelocateCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.relocate(10);
        assertEquals(100, testProduct.getCurrentStock());
    }

    @Test
    public void testStockRelocateLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.relocate(10);
        assertEquals(190, testProduct.getCurrentStock());
    }

    @Test
    public void testStockRelocateNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.relocate(10);
        assertEquals(490, testProduct.getCurrentStock());
    }

    @Test
    public void testStockRelocateStockHigh() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.relocate(10);
        assertEquals(990, testProduct.getCurrentStock());
    }

    //Relocate() status CRITICAL
    @Test
    public void testStatusRelocateCriticalStillCritical() {
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.relocate(10);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //Relocate() status Low
    @Test
    public void testStatusRelocateLowStillLow() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.relocate(10);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusRelocateLowToCritical() {
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.relocate(200);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //Relocate() status NORMAL
    @Test
    public void testStatusRelocateNormalStillNormal() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.relocate(10);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusRelocateNormalToLow() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.relocate(300);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusRelocateNormalToCritical() {
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.relocate(400);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //Relocate() status HIGH
    @Test
    public void testStatusRelocateHighToNormal() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.relocate(400);
        assertEquals(testProduct.getStatus(), new Normal());
    }

    @Test
    public void testStatusRelocateHighToLow() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.relocate(800);
        assertEquals(testProduct.getStatus(), new Low());
    }

    @Test
    public void testStatusRelocateHighToCritical() {
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.relocate(900);
        assertEquals(testProduct.getStatus(), new Critical());
    }

    //-----------------------------------
    //Utils
    private void setStockToHundredAndStatusToCritical(Product product) {
        product.buy(1000);
        product.sell(900);
    }

    private void setStockToTwoHundredAndStatusToLow(Product product) {
        product.buy(1000);
        product.sell(800);
    }

    private void setStockToFiveHundredAndStatusToNormal(Product product) {
        product.buy(1000);
        product.sell(500);
    }

    private void setStockToThousandAndStatusToHigh(Product product) {
        product.buy(1000);
    }
}
