package com.syntra.tristanyannick.model.stock;

public class Stock {

    private StockMovement stockMovement;
    private int amount;
    private boolean hasHappened;

    public Stock(StockMovement stockMovement, boolean hasHappened, int amount) {
        this.stockMovement = stockMovement;
        this.hasHappened = hasHappened;
        this.amount = amount;
    }

    /**
     * Get the current amount of stock.
     *
     * @return the amount of stock as an Integer
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Get the current stockmovement
     *
     * @return a {@link StockMovement}
     * @see StockMovement
     */
    public StockMovement getStockMovement() {
        return stockMovement;
    }

    /**
     * A boolean method to check if the movement executed
     *
     * @return true if movement executed. False if it didn't
     */
    public boolean isHasHappened() {
        return hasHappened;
    } //TODO: Eventueel hernoemen naar hasHappend of stockmovementIsExecuted ?

    @Override
    public String toString() {
        return stockMovement.toString() +
                ": " + amount + "; has happened: " + hasHappened;
    }
}
