package com.syntra.tristanyannick.model.statuses;

import com.syntra.tristanyannick.model.products.Product;
import com.syntra.tristanyannick.model.stock.Stock;
import com.syntra.tristanyannick.model.stock.StockMovement;

public abstract class Status {

    protected StatusDescription statusDescription;

    /**
     * Buys a product: Checks if the amount to buy is lower than {@link Product#getFreeSpace()} if available space is lower
     * than amount ordered then it'll buy the remaining amount left. Afterwards a new state is calculated.
     *
     * @param product Takes a {@link Product}
     * @param amount  Amount of products for stockmovement - varies on method
     */

    public void buy(Product product, int amount) {
        if (amount <= product.getFreeSpace()) {
            product.addStock(new Stock(StockMovement.IN_BUY, true, amount));
            System.out.println("--> Bought x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getFreeSpace();
            product.addStock(new Stock(StockMovement.IN_BUY, true, newAmount));
            System.out.println("--> Bought x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }

    /**
     * Same implementation as {@link Status#buy(Product, int amount)}
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */

    public void produce(Product product, int amount) {
        if (amount <= product.getFreeSpace()) {
            product.addStock(new Stock(StockMovement.IN_PRODUCTION, true, amount));
            System.out.println("--> Produced x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getFreeSpace();
            product.addStock(new Stock(StockMovement.IN_PRODUCTION, true, newAmount));
            System.out.println("--> Produced x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }

    /**
     * Same implementation as {@link Status#buy(Product, int amount)}
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */

    public void sell(Product product, int amount) {
        if (amount <= product.getCurrentStock()) {
            product.addStock(new Stock(StockMovement.OUT_SELL, true, amount));
            System.out.println("--> Sold x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getCurrentStock();
            product.addStock(new Stock(StockMovement.OUT_SELL, true, newAmount));
            System.out.println("--> Sold x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }

    /**
     * Same implementation as {@link Status#buy(Product, int amount)}
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */

    public void relocate(Product product, int amount) {
        if (amount <= product.getCurrentStock()) {
            product.addStock(new Stock(StockMovement.OUT_RELOCATE, true, amount));
            System.out.println("--> Relocated x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getCurrentStock();
            product.addStock(new Stock(StockMovement.OUT_RELOCATE, true, newAmount));
            System.out.println("--> Relocated x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }

    /**
     * Same implementation as {@link Status#buy(Product, int amount)}
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */

    public void remove(Product product, int amount) {
        if (amount <= product.getCurrentStock()) {
            product.addStock(new Stock(StockMovement.OUT_REMOVE, true, amount));
            System.out.println("--> Removed x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getCurrentStock();
            product.addStock(new Stock(StockMovement.OUT_REMOVE, true, newAmount));
            System.out.println("--> Removed x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }

    /**
     * Calculates a new state for the given {@link Product}
     *
     * @param product Takes a {@link Product}
     * @return a new {@link Status}
     */

    private static Status calculateNewState(Product product) {
        if (product.getCurrentStock() <= product.AMOUNT_CRITICAL)
            return new Critical();
        if (product.getCurrentStock() <= product.AMOUNT_LOW)
            return new Low();
        if (product.getCurrentStock() >= product.AMOUNT_HIGH)
            return new High();
        return new Normal();
    }

    @Override
    public String toString() {
        return statusDescription.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Status)
            return statusDescription.toString().equals(obj.toString());
        return false;
    }
}
