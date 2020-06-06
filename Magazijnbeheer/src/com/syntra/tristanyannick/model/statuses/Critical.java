package com.syntra.tristanyannick.model.statuses;

import com.syntra.tristanyannick.model.products.Product;
import com.syntra.tristanyannick.model.stock.Stock;
import com.syntra.tristanyannick.model.stock.StockMovement;

/**
 * Critical state of state design pattern. If a product reaches this state, movements are blocked temporarily.
 */
public class Critical extends Status {

    /**
     * Critical state of state design pattern
     */
    public Critical() {
        this.statusDescription = StatusDescription.CRITICAL;
    }

    /**
     * Sells a new {@link Product} based on the specified amount. Selling of a product does NOT happen when an object has a critical state
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */
    @Override
    public void sell(Product product, int amount) {
        product.addStock(new Stock(StockMovement.OUT_SELL, false, amount));
        printWarning("sell");
    }

    /**
     * Relocates a new {@link Product} based on the specified amount. Relocation does NOT happen when an object has a critical state
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */
    @Override
    public void relocate(Product product, int amount) {
        product.addStock(new Stock(StockMovement.OUT_RELOCATE, false, amount));
        printWarning("relocate");
    }

    /**
     * Removes a new {@link Product} based on the specified amount. Removal does NOT happen when an object has a critical state
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */
    @Override
    public void remove(Product product, int amount) {
        product.addStock(new Stock(StockMovement.OUT_REMOVE, false, amount));
        printWarning("remove");
    }

    /**
     * Prints out a warning to let user know a movement was not executed properly.
     *
     * @param action - A string to let the user know something went wrong.
     */
    private void printWarning(String action) {
        System.out.println("--> Status " + statusDescription.toString() + "! Didn't " + action + " anything.");
    }
}
