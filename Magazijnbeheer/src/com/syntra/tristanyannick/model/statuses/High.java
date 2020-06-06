package com.syntra.tristanyannick.model.statuses;

import com.syntra.tristanyannick.model.products.Product;
import com.syntra.tristanyannick.model.stock.Stock;
import com.syntra.tristanyannick.model.stock.StockMovement;

public class High extends Status {

    /**
     * High state of a product. If product reaches this state the stock needs to be lowered ASAP.
     */
    public High() {
        statusDescription = StatusDescription.HIGH;
    }

    /**
     * Buys a new {@link Product} based on the specified amount.
     *
     * @param product Takes a {@link Product}
     * @param amount  Amount of products for stockmovement - varies on method
     */
    @Override
    public void buy(Product product, int amount) {
        product.addStock(new Stock(StockMovement.IN_BUY, false, amount));
        printWarning("buy");
    }

    /**
     * Produces a new {@link Product} based on the specified amount.
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */
    @Override
    public void produce(Product product, int amount) {
        product.addStock(new Stock(StockMovement.IN_PRODUCTION, false, amount));
        printWarning("produce");
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
